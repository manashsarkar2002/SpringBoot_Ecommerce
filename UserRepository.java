package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 User findByEmailAndPassword(String email,String pass);
}
