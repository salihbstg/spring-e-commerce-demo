package com.example.ecommercedemo.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private long id;
    private long productId;
    private long userId;
}
