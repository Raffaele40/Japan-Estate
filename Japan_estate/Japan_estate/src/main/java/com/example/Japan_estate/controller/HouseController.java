package com.example.Japan_estate.controller;

import com.example.Japan_estate.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {

    @Autowired private HouseService service;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("houses", service.getAll());
        return "index";
    }


}
