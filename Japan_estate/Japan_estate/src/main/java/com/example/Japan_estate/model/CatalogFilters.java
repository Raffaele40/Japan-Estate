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
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
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
        return (cities == null || cities.isEmpty()) && (minPrice == null || minPrice == 0) && (maxPrice == null || maxPrice == 0) && (minRooms == null || minRooms <= 0) && (maxRooms == null || maxRooms <= 0) && (minSize == null || minSize <= 0) && (maxSize == null || maxSize <= 0) && available;
    }

    public boolean matchesBuy(House h){
        if (available && !h.isAvailable()){ return false; }
        if (cities != null && !cities.isEmpty() && !cities.contains(h.getCity())){ return false; }
        if (minPrice != null && h.getBuyPrice() < minPrice){ return false; }
        if (maxPrice != null && h.getBuyPrice() > maxPrice){ return false; }
        if (minRooms != null && h.getRooms() < minRooms){ return false; }
        if (maxRooms != null && h.getRooms() > maxRooms){ return false; }
        if (minSize != null && h.getSize() < minSize){ return false; }
        if (maxSize != null && h.getSize() > maxSize){ return false; }
        return true;
    }

    public boolean matchesRent(House h){
        if (available && !h.isAvailable()){ return false; }
        if (cities != null && !cities.isEmpty() && !cities.contains(h.getCity())){ return false; }
        if (minPrice != null && h.getRentPrice() < minPrice){ return false; }
        if (maxPrice != null && h.getRentPrice() > maxPrice){ return false; }
        if (minRooms != null && h.getRooms() < minRooms){ return false; }
        if (maxRooms != null && h.getRooms() > maxRooms){ return false; }
        if (minSize != null && h.getSize() < minSize){ return false; }
        if (maxSize != null && h.getSize() > maxSize){ return false; }
        return true;
    }

    @Override
    public String toString() {
        return "CatalogFilters{" +
                "cities=" + cities +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minRooms=" + minRooms +
                ", maxRooms=" + maxRooms +
                ", minSize=" + minSize +
                ", maxSize=" + maxSize +
                ", available=" + available +
                '}';
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
        this.minRooms = null;
        this.maxRooms = null;
        this.minSize = null;
        this.maxSize = null;
        this.available = true;
    }
}
