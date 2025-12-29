package com.example.Japan_estate.service;

import com.example.Japan_estate.model.CityEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.Normalizer;
import java.util.List;

@Service
public class CityLoader {
    private List<CityEntry> cityList;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<CityEntry> rawList = mapper.readValue(
                new ClassPathResource("static/data/japan_cities.json").getInputStream(),
                new TypeReference<List<CityEntry>>() {}
        );
        rawList.forEach(city -> city.setCity(normalizeCity(city.getCity())));

        this.cityList = rawList;
    }

    private String normalizeCity(String city) {
        if (city == null){ return null; }

        String normalized = Normalizer.normalize(city, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase()
                .trim();
        return normalized.substring(0,1).toUpperCase() + normalized.substring(1);
    }

    public List<CityEntry> getCityList(){
        return cityList;
    }

}
