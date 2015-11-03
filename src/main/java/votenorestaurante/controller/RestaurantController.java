package votenorestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import votenorestaurante.model.Restaurant;
import votenorestaurante.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping(value = "/protected")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView load() {
        return new ModelAndView("vote");
    }

    @RequestMapping(value="/home", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> loadSteakhouse(){
        restaurantService.populate();
        List<Restaurant> restaurants = restaurantService.listAllByType("steakhouse");
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @RequestMapping(value="/vote", method = RequestMethod.PUT)
    public ResponseEntity<?> vote(@RequestBody Restaurant restaurant){
        restaurantService.updateVotes(restaurant);
        return loadChurrascaria();
    }

    private ResponseEntity<?> loadChurrascaria(){
        List<Restaurant> restaurants = restaurantService.listAllByType("churrascaria");

        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }
}