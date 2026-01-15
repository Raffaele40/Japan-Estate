package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.User;
import com.example.Japan_estate.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.KeyStore;
import java.time.LocalDate;

@Controller
public class UserController {

    @Autowired private UserService service;

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, @RequestParam int bDay_day, @RequestParam int bDay_month, @RequestParam int bDay_year, Model model){
        LocalDate birthDate = LocalDate.of(bDay_year, bDay_month, bDay_day);
        user.setbDay(birthDate);

        if (!service.checkParams(user)) {
            model.addAttribute("error", "Fill every field");
            return "register";
        }
        User saved = service.register(user);
        if (saved == null){
            model.addAttribute("error", "Email already registered");
            return "user/register";
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

    @GetMapping("/user/profile")
    public String showProfile(HttpSession session){
//        if(session.getAttribute("loggedUser") == null){
//            return "/login";
//        }
        return "/user/profile";
    }
}
