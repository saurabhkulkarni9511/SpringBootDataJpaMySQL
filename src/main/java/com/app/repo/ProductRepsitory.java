package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepsitory extends JpaRepository<Product, Integer>{

}
