package com.example.ecommercedemo.repository;


import com.example.ecommercedemo.entity.Product;
import com.example.ecommercedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
    @Query("select ud from users ud where ud.username=?1")
    User findByUsername(String username);

}
