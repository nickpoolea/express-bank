package com.expressbank.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expressbank.demo.models.User;
import com.expressbank.demo.services.UserService;

@RestController
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("login")
	public boolean login(@RequestBody User userDetails) {
		return userService.validateUser(userDetails);		
	}

}
