package com.example.ecommercedemo.repository;

import com.example.ecommercedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    Product findByProductName(@Param("productName") String productName);
}
