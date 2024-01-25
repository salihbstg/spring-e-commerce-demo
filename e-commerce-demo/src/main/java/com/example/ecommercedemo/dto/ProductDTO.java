package com.example.ecommercedemo.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private long id;

    private String productName;

    private long categoryId;

    private float productPrice;

    private int productStock;
}
