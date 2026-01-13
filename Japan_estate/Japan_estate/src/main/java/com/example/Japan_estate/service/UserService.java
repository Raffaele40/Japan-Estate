package com.example.Japan_estate.service;

import com.example.Japan_estate.model.User;
import com.example.Japan_estate.model.UserBasket;
import com.example.Japan_estate.repository.IRepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private IRepoUser userRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    public User register(User user){
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            return null;
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        UserBasket basket = new UserBasket(user);
        user.setBasket(basket);
        return userRepo.save(user);
    }

    public User login(String email, String rawPassword){
        User user = userRepo.findByEmail(email).orElse(null);
        if(user != null && passwordEncoder.matches(rawPassword, user.getPassword())){
            return user;
        }
        return null;
    }

    public boolean checkParams(User user){
        if(user.getName() == null || user.getName().isBlank() || user.getSurname() == null || user.getSurname().isBlank() || user.getEmail() == null || user.getEmail().isBlank() || user.getPassword() == null || user.getPassword().isBlank() || user.getGender() == null || user.getGender().isBlank() || user.getbDay() == null){
            return false;
        }
        return true;
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }

    public boolean deleteByEmail(String email){
        boolean exists = userRepo.existsByEmail(email);
        if(exists){
            userRepo.deleteByEmail(email);
        }
        return exists;
    }

    public void delete(User user){
        userRepo.delete(user);
    }

    public Long count(){
        return userRepo.count();
    }

    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public List<User> findByName(String name){
        return userRepo.findByName(name);
    }

    public List<User> findByNameAndSurname(String name, String surname){
        return userRepo.findByNameAndSurname(name, surname);
    }
}
