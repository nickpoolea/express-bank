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
import com.expressbank.demo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	public UserController() {}
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	private List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	private User getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return userRepo.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("User", "id", id)
		);
	}

	@PostMapping("") 
	private User createUser(@Valid @RequestBody User user) {		
		return userRepo.save(user);
	}
	
	@PutMapping("/{id}")
	private User updateUser(@PathVariable(value = "id") Long id,
							@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepo.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("User", "id", id)
		);
		
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		
		return userRepo.save(user);
	}
	
	@DeleteMapping("/{id}")
	private User deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		User user = userRepo.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("User", "id", id)
		);
		
		userRepo.delete(user);
		
        return user;
	}
}
