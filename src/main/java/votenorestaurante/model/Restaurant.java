package votenorestaurante.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int restaurantId;

    private String name;
    private int totalGrade;

    @Transient
    private int userGrade;

    private String type;
    private String img;
    private String description;

    public Restaurant() {
    }

    public Restaurant(String name, int totalGrade, String type, String img, String description) {
        super();
        this.name = name;
        this.totalGrade = totalGrade;
        this.type = type;
        this.img = img;
        this.description = description;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int id) {
        this.restaurantId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
