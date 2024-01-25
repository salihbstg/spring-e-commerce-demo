package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.business.UserManager;
import com.example.ecommercedemo.dto.UserDTO;
import com.example.ecommercedemo.entity.User;
import com.example.ecommercedemo.exception.ApplicationExceptionImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManager userManager;
    private final ModelMapper modelMapper;

    @GetMapping("/{identifier}")
    public ResponseEntity<UserDTO> findByIdOrUsername(@PathVariable String identifier){

        if (identifier.matches("\\d+")) {
            int id = Integer.parseInt(identifier);
            UserDTO userDTO = userManager.findById(id);
            if(userDTO==null){
                throw new ApplicationExceptionImpl("User not found!");
            }
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }

        else {
            User user = userManager.findByUsername(identifier);
            if(user==null){
                throw new ApplicationExceptionImpl("User not found!");
            }
            return new ResponseEntity<>(modelMapper.map(user, UserDTO.class), HttpStatus.OK);
        }
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<>(userManager.findAll(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userManager.saveUser(userDTO),HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Long> save(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userManager.saveUser(userDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return new ResponseEntity<>(userManager.deleteUser(id),HttpStatus.OK);
    }

}
