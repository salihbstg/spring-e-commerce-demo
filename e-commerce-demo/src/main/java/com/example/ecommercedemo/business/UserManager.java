package com.example.ecommercedemo.business;

import com.example.ecommercedemo.dto.UserDTO;
import com.example.ecommercedemo.entity.User;
import com.example.ecommercedemo.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager {
    private final UserJpaRepository userJpaRepository;
    private final ModelMapper modelMapper;

    public UserDTO findById(int id){
        Optional<User> user=userJpaRepository.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user,UserDTO.class);
        }
        return null;

    }
    public List<UserDTO> findAll(){
        List<User> userList = userJpaRepository.findAll();
        List<UserDTO> userDTOList=new ArrayList<>();
        for(User user:userList){
            userDTOList.add(modelMapper.map(user,UserDTO.class));
        }
        return userDTOList;
    }
    public User findByUsername(String username){
        return userJpaRepository.findByUsername(username);
    }
    public long saveUser(UserDTO userDTO){
        User user=modelMapper.map(userDTO,User.class);
        userJpaRepository.save(user);
        return user.getId();
    }
    public String deleteUser(int id){
        User user=modelMapper.map(userJpaRepository.findById(id),User.class);
        userJpaRepository.delete(user);
        return "User deleted!";
    }



}
