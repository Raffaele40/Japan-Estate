package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.CatalogFilters;
import com.example.Japan_estate.model.CityEntry;
import com.example.Japan_estate.model.House;
import com.example.Japan_estate.model.User;
import com.example.Japan_estate.service.CityLoader;
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
    @Autowired private CityLoader cityLoader;

    @GetMapping("/")
    public String home(@ModelAttribute CatalogFilters filters, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("user", user);

        List<House> houses = service.getFilteredHousesBuy(filters);

        model.addAttribute("houses", houses);

        List<String> allCities = cityLoader.getCityList().stream()
                        .map(CityEntry::getCity)
                        .sorted()
                        .toList();
        model.addAttribute("allCities", allCities);
        model.addAttribute("filters", filters);
        return "index";
    }

    @GetMapping("/rent_catalog")
    public String rentCatalog(@ModelAttribute CatalogFilters filters, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("user", user);

        List<House> houses = service.getFilteredHousesRent(filters);

        model.addAttribute("houses", houses);

        List<String> allCities = cityLoader.getCityList().stream()
                .map(CityEntry::getCity)
                .sorted()
                .toList();
        model.addAttribute("allCities", allCities);
        model.addAttribute("filters", filters);
        return "rentCatalog";
    }

    @GetMapping("/house_details/{id}")
    public String houseDetails(@PathVariable Integer id, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("user", user);

        House house = service.findById(id)
                        .orElseThrow(() -> new RuntimeException("House not found"));
        model.addAttribute("houseDetails", house);
        return "houseDetails";
    }

}
