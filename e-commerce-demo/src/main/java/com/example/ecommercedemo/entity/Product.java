package com.example.ecommercedemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="product_name")
    private String productName;
    @Column(name="category_id")
    private long categoryId;
    @Column(name="product_price")
    private float productPrice;
    @Column(name="product_stock")
    private int productStock;
}
