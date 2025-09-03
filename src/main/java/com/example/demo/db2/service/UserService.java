package com.example.demo.db2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db2.model.User;
import com.example.demo.db2.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    // Service method to save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
