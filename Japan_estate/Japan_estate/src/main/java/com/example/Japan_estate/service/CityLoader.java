package com.example.Japan_estate.service;

import com.example.Japan_estate.model.CityEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CityLoader {
    private List<CityEntry> cityList;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        cityList = mapper.readValue(
                new ClassPathResource("static/data/japan_cities.json").getInputStream(),
                new TypeReference<List<CityEntry>>() {}
        );
    }

    public List<CityEntry> getCityList(){
        return cityList;
    }
}
