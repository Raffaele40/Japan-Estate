package com.example.Japan_estate.repository;

import com.example.Japan_estate.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepoHouse extends JpaRepository<House, Integer> {
    List<House> findByCityIn(List<String> city);
    List<House> findByPriceLessThan(double price);
    List<House> findByRoomsLessThan(int rooms);
    List<House> findBySizeLessThan(int size);
    @Query("SELECT h FROM House h WHERE h.available = TRUE")
    List<House> getAvailableHouses();
}
