package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.House;
import com.example.Japan_estate.model.User;
import com.example.Japan_estate.service.HouseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HouseController {

    @Autowired private HouseService service;

    @GetMapping("/")
    public String home(@RequestParam(name = "cityFilter", required = false) List<String> cityFilter, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("user", user);

        List<House> houses = service.getAll();
        List<House> availableHouses = service.getAvailableHouses();

        if(cityFilter != null) {
            availableHouses.clear();
            availableHouses.addAll(service.findByCityIn(cityFilter).stream()
                    .filter(house -> house.isAvailable())
                    .toList());
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
