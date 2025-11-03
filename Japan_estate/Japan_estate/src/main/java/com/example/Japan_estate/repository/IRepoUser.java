package com.example.Japan_estate.repository;

import com.example.Japan_estate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepoUser extends JpaRepository<User, String> {
}
