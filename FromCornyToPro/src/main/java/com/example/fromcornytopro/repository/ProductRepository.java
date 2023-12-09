package com.example.fromcornytopro.repository;

import com.example.fromcornytopro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
