package com.example.demo.db2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db2.model.User;
import com.example.demo.db2.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	 @Autowired
	    private UserService userService;

	    // Endpoint to save a user
	    @PostMapping("/saveUser")
	    public ResponseEntity<User> save(@RequestBody User user){
	        User myuser = userService.saveUser(user);
	        return new ResponseEntity<>(myuser, HttpStatus.OK);
	    }

}
