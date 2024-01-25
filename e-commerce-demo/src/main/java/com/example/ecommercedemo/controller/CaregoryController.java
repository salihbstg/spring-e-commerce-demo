package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.business.CategoryManager;
import com.example.ecommercedemo.dto.CategoryDTO;
import com.example.ecommercedemo.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CaregoryController {
    private final CategoryManager categoryManager;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategoryList(){
        ResponseEntity<List<CategoryDTO>> listResponseEntity = new ResponseEntity<>(categoryManager.getCategoryList(), HttpStatus.OK);
        return listResponseEntity;
    }
    @GetMapping("/{name}")
    public ResponseEntity<Category> getProductById(@PathVariable String name){

        return new ResponseEntity<>(categoryManager.findByName(name),HttpStatus.OK);
    }
}
