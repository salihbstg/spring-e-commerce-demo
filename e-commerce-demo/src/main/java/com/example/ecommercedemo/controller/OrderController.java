package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.business.OrderManager;
import com.example.ecommercedemo.dto.OrderDTO;
import com.example.ecommercedemo.exception.ApplicationExceptionImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderManager orderManager;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        ResponseEntity<List<OrderDTO>> listResponseEntity = new ResponseEntity<>(orderManager.getOrderList(), HttpStatus.OK);
        return listResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable int id) {
        OrderDTO orderDTO=orderManager.findById(id);
        if(orderDTO==null){
            throw new ApplicationExceptionImpl("Order not found!");
        }
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderManager.saveOrder(orderDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderManager.saveOrder(orderDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        return new ResponseEntity<>(orderManager.deleteOrder(id), HttpStatus.OK);
    }
}
