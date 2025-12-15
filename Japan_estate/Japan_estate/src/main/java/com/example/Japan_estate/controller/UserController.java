package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.User;
import com.example.Japan_estate.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired private UserService service;

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model){
        User saved = service.register(user);
        if (saved == null){
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model){
        User user = service.login(email, password);
        if (user == null){
            model.addAttribute("error", "Email or password not valid");
            return "login";
        }
        session.setAttribute("loggedUser", user);
        return "redirect:/";
    }

}
