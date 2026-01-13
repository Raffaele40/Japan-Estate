package com.example.Japan_estate.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_basket")
public class UserBasket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_email", nullable = false)
    private User user;

    @ManyToMany
    private List<House> houses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "UserBasket{" +
                "id=" + id +
                ", user=" + user +
                ", houses=" + houses +
                '}';
    }

    public UserBasket(){}

    public UserBasket(User user){
        this.user = user;
    }

    public UserBasket(Long id, User user, List<House> houses) {
        this.id = id;
        this.user = user;
        this.houses = houses;
    }
}
