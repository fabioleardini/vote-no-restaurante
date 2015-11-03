package votenorestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import votenorestaurante.model.Restaurant;
import votenorestaurante.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public void populate(){
        if(restaurantRepository.count() == 0) {

            Restaurant restaurant = new Restaurant();
            restaurant.setName("Outback");
            restaurant.setVotes(0);
            restaurant.setType("steakhouse");
            restaurant.setImg("../resources/img/restaurants/outback.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Applebees");
            restaurant.setVotes(0);
            restaurant.setType("steakhouse");
            restaurant.setImg("../resources/img/restaurants/applebees.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Fogo de Chão");
            restaurant.setVotes(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/fogodechao.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Vento Aragano");
            restaurant.setVotes(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/ventoaragano.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);

            restaurant.setName("Jardineira");
            restaurant.setVotes(0);
            restaurant.setType("churrascaria");
            restaurant.setImg("../resources/img/restaurants/jardineira.jpg");
            restaurant.setDescription("");
            restaurantRepository.saveAndFlush(restaurant);
        }
    }

    public List<Restaurant> listAllByType(String type) {
        return restaurantRepository.findByType(type);
    }

    public void updateVotes(Restaurant restaurant) {
        int votes = restaurant.getVotes() + 1;
        restaurant.setVotes(votes);
        restaurantRepository.save(restaurant);
    }
}
