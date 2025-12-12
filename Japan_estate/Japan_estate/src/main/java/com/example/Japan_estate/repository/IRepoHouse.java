package com.example.Japan_estate.repository;

import com.example.Japan_estate.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepoHouse extends JpaRepository<House, Integer> {
    List<House> findByCityIn(List<String> city);
    List<House> findByPriceLessThan(double price);
    List<House> findByRoomsLessThan(int rooms);
    List<House> findBySizeLessThan(int size);
    List<House> findByAvailable(boolean available);
}
