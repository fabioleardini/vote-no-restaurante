package votenorestaurante.vo;


import votenorestaurante.model.Restaurant;
import votenorestaurante.model.RestaurantArrayList;

import java.util.List;

public class RestaurantVO {

    private List<Restaurant> restaurantList;

    private String userEmail;
    private String userName;

    public RestaurantVO() {
    }

    public RestaurantVO(List<Restaurant> restaurantList, String userEmail, String userName) {
        this.restaurantList = restaurantList;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
