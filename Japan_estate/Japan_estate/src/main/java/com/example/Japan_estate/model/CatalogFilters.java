package com.example.Japan_estate.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogFilters {
    private List<String> cities;
    private Double minPrice;
    private Double maxPrice;
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

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        if(minPrice == null){
            this.minPrice = 0.0;
        }
        else {
            this.minPrice = minPrice;
        }
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        if (maxPrice == null){
            this.maxPrice = 0.0;
        }
        else {
            this.maxPrice = maxPrice;
        }
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
        return (cities == null || cities.isEmpty()) && (minPrice == null || minPrice == 0) && (maxPrice == null || maxPrice == 0) && minRooms <= 0 && maxRooms <= 0 && minSize <= 0 && maxSize <= 0 && available;
    }

    public CatalogFilters(List<String> cities, Double minPrice, Double maxPrice, Integer minRooms, Integer maxRooms, Integer minSize, Integer maxSize, boolean available) {
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
        this.minPrice = null;
        this.maxPrice = null;
        this.minRooms = 0;
        this.maxRooms = 0;
        this.minSize = 0;
        this.maxSize = 0;
        this.available = true;
    }

}
