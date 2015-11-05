package votenorestaurante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int userid;

    private String email;
    private String name;

    private int rankingid;

    public User() {
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int id) {
        this.userid = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRankingId() {
        return rankingid;
    }

    public void setRankingId(int rankingid) {
        this.rankingid = rankingid;
    }
}