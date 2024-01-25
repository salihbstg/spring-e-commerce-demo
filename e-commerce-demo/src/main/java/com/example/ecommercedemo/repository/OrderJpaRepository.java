package com.example.ecommercedemo.repository;

import com.example.ecommercedemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order,Integer> {
}
