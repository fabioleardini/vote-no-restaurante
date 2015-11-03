package votenorestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import votenorestaurante.model.Restaurant;
import votenorestaurante.repository.RestaurantRepository;

import javax.annotation.PostConstruct;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    Restaurant restaurant;

//    @PostConstruct
//    @Transactional
//    public void pouplate(){
//        Restaurant restaurant = new Restaurant();
//        restaurant.setName("Outback");
//        restaurant.setVotes(0);
//        restaurant.setImg("../resources/img/restaurants/outback.jpg");
//        restaurantRepository.saveAndFlush(restaurant);
//
//        restaurant.setName("Applebees");
//        restaurant.setVotes(0);
//        restaurant.setImg("../resources/img/restaurants/applebees.jpg");
//        restaurantRepository.saveAndFlush(restaurant);
//    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
