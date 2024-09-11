package com.alpha.shopapplication.controllers;

import com.alpha.shopapplication.models.ApiResponse;
import com.alpha.shopapplication.models.User;
import com.alpha.shopapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<ApiResponse<User>> authenticateUser(@RequestBody User user) {
        List<User> foundUsers = userService.getUserByEmail(user.getEmail());
        if (foundUsers.isEmpty()) {
            System.out.println("here");
            return new ResponseEntity<>(new ApiResponse<>("User not found"),HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(new ApiResponse<>(),HttpStatus.OK);
        }

    }
}
