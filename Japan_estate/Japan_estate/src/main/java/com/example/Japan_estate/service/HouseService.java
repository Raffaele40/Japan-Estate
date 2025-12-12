package com.example.Japan_estate.service;

import com.example.Japan_estate.model.House;
import com.example.Japan_estate.repository.IRepoHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired IRepoHouse repo;

    public List<House> getAll(){
        return repo.findAll();
    }

    public List<House> findByAvailable(boolean available){
        return repo.findByAvailable(available);
    }

    public List<House> getPriceLessThan(double price){
        return repo.findByPriceLessThan(price);
    }

    public Optional<House> findById(Integer id){
        return repo.findById(id);
    }

    public List<House> findByCityIn(List<String> city){
        return repo.findByCityIn(city);
    }
}
