package votenorestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import votenorestaurante.model.Ranking;
import votenorestaurante.model.Restaurant;
import votenorestaurante.model.RestaurantArrayList;
import votenorestaurante.model.User;
import votenorestaurante.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserService userService;

    @Autowired
    RankingService rankingService;

    public void populate(){
        if(restaurantRepository.count() == 0) {

            Restaurant restaurant = new Restaurant();
            restaurant.setName("Outback");
            restaurant.setTotalGrade(0);
            restaurant.setType("steakhouse");
            restaurant.setImg("../resources/img/restaurants/outback.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Applebee's");
            restaurant.setTotalGrade(0);
            restaurant.setType("steakhouse");
            restaurant.setImg("../resources/img/restaurants/applebees.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Fogo de Chão");
            restaurant.setTotalGrade(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/fogodechao.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Vento Aragano");
            restaurant.setTotalGrade(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/ventoaragano.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Jardineira");
            restaurant.setTotalGrade(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/jardineira.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);
        }
    }

    public List<Restaurant> findByType(String type) {
        return restaurantRepository.findByType(type);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll(new Sort(Sort.Direction.DESC, "totalGrade"));
    }

    public List<Ranking> findByUseremail(String userEmail) {
        return rankingService.findByUseremail(userEmail);
    }

    public String checkUser(RestaurantArrayList restaurants, User user){
        if(userExists(user)){
            return "userexists";
        }

        saveUser(user);

        return updateGrade(restaurants, user.getEmail());
    }

    public String updateGrade(RestaurantArrayList restaurants, String userEmail) {
        int grade = 0;

        for(Restaurant restaurant : restaurants) {
            grade = restaurant.getTotalGrade() + restaurant.getUserGrade();
            restaurant.setTotalGrade(grade);

            restaurantRepository.save(restaurant);
            rankingService.save(new Ranking(userEmail, restaurant.getName(), restaurant.getUserGrade()));
        }

        return "success";
    }

    public boolean userExists(User user){
        return (userService.findByEmail(user.getEmail()) != null);
    }

    public void saveUser(User user){userService.save(user);}
}
