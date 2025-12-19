package com.example.Japan_estate.service;

import com.example.Japan_estate.model.User;
import com.example.Japan_estate.repository.IRepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private IRepoUser repo;

    public User register(User user){
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return null;
        }
        return repo.save(user);
    }

    public User login(String email, String password){
        User user = repo.findByEmail(email)
                .orElseThrow(NoSuchElementException::new);
        if(user != null && user.getPassword().equals(password)){
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
        return repo.findAll();
    }

    public boolean existsByEmail(String email){
        return repo.existsByEmail(email);
    }

    public boolean deleteByEmail(String email){
        boolean exists = repo.existsByEmail(email);
        if(exists){
            repo.deleteByEmail(email);
        }
        return exists;
    }

    public void delete(User user){
        repo.delete(user);
    }

    public Long count(){
        return repo.count();
    }

    public Optional<User> findByEmail(String email){
        return repo.findByEmail(email);
    }

    public List<User> findByName(String name){
        return repo.findByName(name);
    }

    public List<User> findByNameAndSurname(String name, String surname){
        return repo.findByNameAndSurname(name, surname);
    }
}
