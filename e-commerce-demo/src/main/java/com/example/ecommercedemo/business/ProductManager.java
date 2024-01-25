package com.example.ecommercedemo.business;

import com.example.ecommercedemo.dto.ProductDTO;
import com.example.ecommercedemo.entity.Product;

import com.example.ecommercedemo.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager {
    private final ProductJpaRepository productJpaRepository;
    private final ModelMapper modelMapper;
    public List<ProductDTO> findAll(){
       List<Product> productList=productJpaRepository.findAll();
       List<ProductDTO> productDTOList=new ArrayList<>();
       for(Product temp:productList){
           productDTOList.add(modelMapper.map(temp, ProductDTO.class));
       }
       return productDTOList;
    }
    public ProductDTO findById(int id){
        return modelMapper.map(productJpaRepository.findById(id), ProductDTO.class);
    }
    public ProductDTO findByProductName(String productName){
        return modelMapper.map(productJpaRepository.findByProductName(productName), ProductDTO.class);
    }
    public String saveProduct(ProductDTO productDTO){
        Product product=modelMapper.map(productDTO,Product.class);
        productJpaRepository.save(product);
        return "Product saved!";
    }
    public String deleteProduct(int id){
        Product product=modelMapper.map(findById(id),Product.class);
        productJpaRepository.delete(product);
        return "Product deleted!";
    }

}
