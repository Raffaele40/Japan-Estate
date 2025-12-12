package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.House;
import com.example.Japan_estate.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HouseController {

    @Autowired private HouseService service;

    @GetMapping("/")
    public String home(@RequestParam(name = "cityFilter", required = false) List<String> cityFilter, Model model){
        List<House> houses = service.getAll();
        List<House> availableHouses = service.findByAvailable(true);

        if(cityFilter != null) {
            availableHouses.clear();
            for (House houseF: service.findByCityIn(cityFilter)){
                availableHouses.add(houseF);
            }
        }

        model.addAttribute("houses", availableHouses);
        model.addAttribute("cityFilter", cityFilter);

        return "index";
    }

    @GetMapping("/house_details/{id}")
    public String houseDetails(@PathVariable Integer id, Model model){
        House house = service.findById(id)
                        .orElseThrow(() -> new RuntimeException("House not found"));
        model.addAttribute("houseDetails", house);
        return "houseDetails";
    }

}
