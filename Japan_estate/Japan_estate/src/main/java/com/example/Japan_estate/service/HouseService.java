package com.example.Japan_estate.service;

import com.example.Japan_estate.model.CatalogFilters;
import com.example.Japan_estate.model.House;
import com.example.Japan_estate.repository.IRepoHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired private IRepoHouse repo;

    public List<House> getAll(){
        return repo.findAll();
    }

    public Optional<House> findById(Integer id){
        return repo.findById(id);
    }

    public boolean existsById(Integer id){
        return  repo.existsById(id);
    }

    public House addNewHouse(House house){
        return repo.save(house);
    }

    public Long count(){
        return repo.count();
    }

    public boolean deleteById(Integer id){
        boolean exists = repo.existsById(id);
        if(exists){
            repo.deleteById(id);
        }
        return exists;
    }

    public void delete(House house){
        repo.delete(house);
    }

    public List<House> getFilteredHousesBuy(CatalogFilters filters){
        return repo.findAll().stream()
                .filter(filters::matchesBuy)
                .toList();
    }

    public List<House> getFilteredHousesRent(CatalogFilters filters){
        return repo.findAll().stream()
                .filter(filters::matchesRent)
                .toList();
    }
}
