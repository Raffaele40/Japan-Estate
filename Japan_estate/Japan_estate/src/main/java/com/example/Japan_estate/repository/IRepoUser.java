package com.example.Japan_estate.repository;

import com.example.Japan_estate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRepoUser extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByName(String name);
    List<User> findByNameAndSurname(String name, String surname);

}
