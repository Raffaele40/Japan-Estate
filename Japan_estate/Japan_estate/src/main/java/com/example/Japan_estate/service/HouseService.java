package com.example.Japan_estate.service;

import com.example.Japan_estate.model.House;
import com.example.Japan_estate.repository.IRepoHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired IRepoHouse repo;

    public List<House> getAll(){
        return repo.findAll();
    }

    public List<House> getPriceLessThan(double price){
        return repo.findByPriceLessThan(price);
    }
}
