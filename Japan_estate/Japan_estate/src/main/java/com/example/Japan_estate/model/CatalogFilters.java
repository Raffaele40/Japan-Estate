package com.example.Japan_estate.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogFilters {
    private List<String> cities;
    private double minPrice;
    private double maxPrice;
    private Integer minRooms;
    private Integer maxRooms;
    private Integer minSize;
    private Integer maxSize;
    private boolean available;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinRooms() {
        return minRooms;
    }

    public void setMinRooms(Integer minRooms) {
        this.minRooms = minRooms;
    }

    public Integer getMaxRooms() {
        return maxRooms;
    }

    public void setMaxRooms(Integer maxRooms) {
        this.maxRooms = maxRooms;
    }

    public Integer getMinSize() {
        return minSize;
    }

    public void setMinSize(Integer minSize) {
        this.minSize = minSize;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isEmpty(){
        return (cities.isEmpty() || cities == null) && minPrice <= 0 && maxPrice >= Double.MAX_VALUE && minRooms <= 0 && maxRooms >= Integer.MAX_VALUE && available;
    }

    public CatalogFilters(List<String> cities, double minPrice, double maxPrice, Integer minRooms, Integer maxRooms, Integer minSize, Integer maxSize, boolean available) {
        this.cities = cities;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minRooms = minRooms;
        this.maxRooms = maxRooms;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.available = available;
    }

    public CatalogFilters() {
        this.cities = new ArrayList<>();
        this.minPrice = 0;
        this.maxPrice = Double.MAX_VALUE;
        this.minRooms = 0;
        this.maxRooms = Integer.MAX_VALUE;
        this.minSize = 0;
        this.maxSize = Integer.MAX_VALUE;
        this.available = true;
    }

}
