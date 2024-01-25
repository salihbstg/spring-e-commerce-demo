package com.example.ecommercedemo.business;

import com.example.ecommercedemo.dto.CategoryDTO;
import com.example.ecommercedemo.entity.Category;
import com.example.ecommercedemo.entity.Product;
import com.example.ecommercedemo.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager {
    private final CategoryJpaRepository categoryJpaRepository;
    private final ModelMapper modelMapper;


    public List<CategoryDTO> getCategoryList() {
        List<Category> categoryList=categoryJpaRepository.findAll();
        List<CategoryDTO> categoryDTOList=new ArrayList<>();
        for(Category temp:categoryList){
            categoryDTOList.add(modelMapper.map(temp,CategoryDTO.class));
        }
        return categoryDTOList;
    }

    public Category findByName(String name) {
        return categoryJpaRepository.findByCategory(name);
    }
}
