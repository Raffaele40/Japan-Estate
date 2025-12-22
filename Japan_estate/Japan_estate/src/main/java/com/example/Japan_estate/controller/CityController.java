package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.CityEntry;
import com.example.Japan_estate.service.CityLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {
    private final CityLoader cityLoader;

    public CityController(CityLoader cityLoader){
        this.cityLoader = cityLoader;
    }

    @GetMapping("/api/cities")
    public List<String> getCities(@RequestParam(required = false) String term){
        return cityLoader.getCityList().stream()
                .map(CityEntry::getCity)
                .filter(city -> term == null || city.toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toList());
    }
}
