package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.business.ProductManager;
import com.example.ecommercedemo.dto.ProductDTO;
import com.example.ecommercedemo.exception.ApplicationExceptionImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductManager productManager;

    @GetMapping("/{idOrName}")
    public ResponseEntity<ProductDTO> findByIdOrName(@PathVariable String idOrName){
        if (idOrName.matches("\\d+")) {
            ProductDTO productDTO = productManager.findById(Integer.parseInt(idOrName));
            if(productDTO==null){
                throw new ApplicationExceptionImpl("Product not found!");
            }
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        }
        else{
            ProductDTO productDTO=productManager.findByProductName(idOrName);
            if(productDTO==null){
                throw new ApplicationExceptionImpl("Product not found!");
            }
            return new ResponseEntity<>(productDTO,HttpStatus.OK);
        }
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return new ResponseEntity<>(productManager.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
         return new ResponseEntity<>(productManager.saveProduct(productDTO),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productManager.saveProduct(productDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return new ResponseEntity<>(productManager.deleteProduct(id),HttpStatus.OK);
    }
}
