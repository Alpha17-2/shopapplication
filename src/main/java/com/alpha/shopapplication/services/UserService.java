package com.alpha.shopapplication.services;

import com.alpha.shopapplication.models.User;
import com.alpha.shopapplication.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // This function is used to create a new user
    public User createUser(User user){
        user = userRepository.save(user);
        return user;
    }

    public List<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
