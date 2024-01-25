package com.example.ecommercedemo.business;

import com.example.ecommercedemo.dto.OrderDTO;
import com.example.ecommercedemo.entity.Order;
import com.example.ecommercedemo.entity.User;
import com.example.ecommercedemo.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager {
    private final OrderJpaRepository orderJpaRepository;
    private final ModelMapper modelMapper;
    public List<OrderDTO> getOrderList(){
        List<Order> orderList=orderJpaRepository.findAll();
        List<OrderDTO> orderDTOList=new ArrayList<>();
        for(Order temp:orderList){
            orderDTOList.add(modelMapper.map(temp,OrderDTO.class));
        }
        return orderDTOList;
    }
    public OrderDTO findById(int id){
        return modelMapper.map(orderJpaRepository.findById(id),OrderDTO.class);
    }
    public String saveOrder(OrderDTO orderDTO){
        Order order=modelMapper.map(orderDTO,Order.class);
        orderJpaRepository.save(order);
        return "Order saved!";
    }
    public String deleteOrder(int id){
        Order order=modelMapper.map(findById(id),Order.class);
        orderJpaRepository.delete(order);
        return "Order deleted!";
    }

}
