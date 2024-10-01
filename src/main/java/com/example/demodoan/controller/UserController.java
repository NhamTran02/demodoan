package com.example.demodoan.controller;

import com.example.demodoan.dto.UserDTO;
import com.example.demodoan.dto.UserLoginDTO;
import com.example.demodoan.model.User;
import com.example.demodoan.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User user = userServiceImpl.createUser(userDTO);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO loginDTO) throws Exception {
        userServiceImpl.login(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok().body("token");
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(userServiceImpl.updateUser(id,userDTO));
    }
}
