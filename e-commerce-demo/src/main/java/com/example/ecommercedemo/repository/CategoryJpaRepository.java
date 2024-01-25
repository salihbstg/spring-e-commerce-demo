package com.example.ecommercedemo.repository;

import com.example.ecommercedemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category,Integer> {
    Category findByCategory(String name);
}
