package com.example.Japan_estate.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String email;

    private String password;
    private String name;
    private String surname;
    private LocalDate bDay;
    private String gender;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserBasket basket;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public UserBasket getBasket() {
        return basket;
    }

    public void setBasket(UserBasket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bDay=" + bDay + '\'' +
                ", gender= " + gender +
                '}';
    }

    public User(){
    }

    public User(String email, String password, String name, String surname, LocalDate bDay, String gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.bDay = bDay;
        this.gender = gender;
    }
}
