package votenorestaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue
    private int rankingid;

    private String useremail;
    private String restaurantname;
    private int grade;

    public Ranking() {
    }

    public Ranking(String useremail, String restaurantname, int grade) {
        this.useremail = useremail;
        this.restaurantname = restaurantname;
        this.grade = grade;
    }

    public int getRankingid() {
        return rankingid;
    }

    public void setRankingid(int id) {
        this.rankingid = id;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
