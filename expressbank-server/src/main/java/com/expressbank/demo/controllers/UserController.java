package com.expressbank.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expressbank.demo.exceptions.ResourceNotFoundException;
import com.expressbank.demo.models.User;
import com.expressbank.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	public UserController() {}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	private User getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return userService.getUserById(id);
	}

	@PostMapping("") 
	private User createUser(@Valid @RequestBody User user) {		
		return userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	private User updateUser(@PathVariable(value = "id") Long id,
							@Valid @RequestBody User user) throws ResourceNotFoundException {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	private User deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return userService.deleteUser(id);
	}
}
