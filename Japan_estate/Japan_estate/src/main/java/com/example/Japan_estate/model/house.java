package com.example.Japan_estate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class house {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private double price;
    private int size;
    private int rooms;
    private boolean available;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "house{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", rooms=" + rooms +
                ", available=" + available +
                '}';
    }
}
