package com.example.Japan_estate.controller;

import com.example.Japan_estate.model.EditProfileDTO;
import com.example.Japan_estate.model.User;
import com.example.Japan_estate.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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
            return "register";
        }
        return "redirect:login";
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

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/user/profile")
    public String showProfile(HttpSession session, Model model){
        if(session.getAttribute("loggedUser") == null){
            return "login";
        }
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("fullName", user.getName() + " " + user.getSurname());
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/user/basket")
    public String showBasket(HttpSession session, Model model){
//        if(session.getAttribute("loggedUser") == null){
//            return "/login";
//        }
        return "user/basket";
    }

    @GetMapping("/user/orders")
    public String showOrders(HttpSession session, Model model){
//        if(session.getAttribute("loggedUser") == null){
//            return "/login";
//        }
        return "user/orders";
    }

    @GetMapping("/user/edit_profile")
    public String showEditProfile(HttpSession session, Model model){
        if(session.getAttribute("loggedUser") == null){
            return "login";
        }
        User user = (User) session.getAttribute("loggedUser");

        EditProfileDTO dto = new EditProfileDTO(user.getName(), user.getSurname(), user.getGender());
        model.addAttribute("editUser", dto);

        dto.setbDayDay(user.getbDay().getDayOfMonth());
        dto.setbDayMonth(user.getbDay().getMonthValue());
        dto.setbDayYear(user.getbDay().getYear());
        model.addAttribute("bDayDay", dto.getbDayDay());
        model.addAttribute("bDayMonth", dto.getbDayMonth());
        model.addAttribute("bDayYear", dto.getbDayYear());

        return "user/editProfile";
    }

    @PostMapping("/user/edit_profile")
    public String editProfile(@ModelAttribute("editUser") EditProfileDTO dto, HttpSession session, Model model){
        if(session.getAttribute("loggedUser") == null){
            return "login";
        }
        User user = (User) session.getAttribute("loggedUser");
        LocalDate bDay = LocalDate.of(dto.getbDayYear(), dto.getbDayMonth(), dto.getbDayDay());

        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setGender(dto.getGender());
        user.setbDay(bDay);

        if(dto.getNewPassword() != null && !dto.getNewPassword().isBlank()){
            if(!service.passwordsMatches(dto.getOldPassword(),user.getPassword())){
                model.addAttribute("error", "Incorrect password");
                return "user/editProfile";
            }
            service.setEncodedPassword(dto.getNewPassword(), user);
        }
        service.updateUser(user);
        session.setAttribute("loggedUser", user);
        return "redirect:profile";
    }
}
