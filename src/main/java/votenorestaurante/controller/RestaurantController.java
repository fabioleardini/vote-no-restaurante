package votenorestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import votenorestaurante.model.Restaurant;
import votenorestaurante.model.RestaurantArrayList;
import votenorestaurante.model.User;
import votenorestaurante.service.RestaurantService;
import votenorestaurante.vo.RestaurantVO;

import java.util.List;

@Controller
@RequestMapping(value = "/protected/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> loadAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.findAll();
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> loadSteakhouseRestaurants(){
        restaurantService.populate();
        List<Restaurant> restaurants = restaurantService.findByType("steakhouse");
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> vote(@RequestBody RestaurantArrayList restaurants,
                                  @RequestParam String inputName,
                                  @RequestParam String inputEmail){

        String result = restaurantService.checkUser(restaurants, new User(inputEmail, inputName));

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/vote", method = RequestMethod.GET, produces = "application/json")
    private ResponseEntity<?> loadChurrascarias(@RequestParam String email, @RequestParam String name){
        List<Restaurant> restaurants = restaurantService.findByType("churrascaria");
        RestaurantVO restaurantVO = new RestaurantVO(restaurants, email, name);

        return new ResponseEntity<RestaurantVO>(restaurantVO, HttpStatus.OK);
    }

    @RequestMapping(value="/vote", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> allVotes(@RequestBody RestaurantArrayList restaurants, @RequestParam String inputEmail){

        String result = restaurantService.updateGrade(restaurants, inputEmail);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}