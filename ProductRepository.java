package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByCategory(String cat);
}
