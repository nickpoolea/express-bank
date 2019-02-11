package com.expressbank.demo.controllers;

import javax.servlet.http.HttpServletResponse;

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
	public User login(@RequestBody User userDetails, HttpServletResponse response) {
		User user = userService.validateUser(userDetails);
		
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return user;
	}
	
	@PostMapping("register")
	public User register(@RequestBody User userDetails, HttpServletResponse response) {
		
		System.out.println(userDetails.toString());
		
		User user = userService.registerUser(userDetails);
		
		
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return user;
	}

}
