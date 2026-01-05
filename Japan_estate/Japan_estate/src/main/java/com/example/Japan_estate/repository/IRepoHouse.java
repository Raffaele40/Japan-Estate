package com.example.Japan_estate.repository;

import com.example.Japan_estate.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepoHouse extends JpaRepository<House, Integer> {

}
