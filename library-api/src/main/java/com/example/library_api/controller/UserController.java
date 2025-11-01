package com.example.library_api.controller;

import com.example.library_api.DTO.UserResponse;
import com.example.library_api.model.User;
import com.example.library_api.service.UserService;
import jakarta.validation.Valid;
import com.example.library_api.DTO.UserRequest;
import com.example.library_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> createUser (@RequestBody @Valid UserRequest userRequest){
        User createUser = userService.createUser(userRequest);

        return ResponseEntity.status(201).body(
                new UserResponse(createUser.getId(),
                createUser.getUserName(),
                createUser.getEmail(), createUser.getAddress(), createUser.getPhone(),
                createUser.getRole().toString())
        
        );



    }
}

