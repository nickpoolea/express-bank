package com.expressbank.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressbank.demo.exceptions.ResourceNotFoundException;
import com.expressbank.demo.models.User;
import com.expressbank.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUserById(Long id) throws ResourceNotFoundException {
		return userRepo.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("User", "id", id)
		);
	}

	public User createUser(User user) {		
		return userRepo.save(user);
	}
	
	public User updateUser(Long id, User userDetails) throws ResourceNotFoundException {
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
	
	public User deleteUser(Long id) throws ResourceNotFoundException {
		User user = userRepo.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("User", "id", id)
		);
		
		userRepo.delete(user);
		
        return user;
	}
	
	public User validateUser(User userDetails) {
		User user = userRepo.findByUsername(userDetails.getUsername());
				
		if (user != null && user.getPassword().equals(userDetails.getPassword())) {
			return user;
		}
		
		return null;
	}
	
	public User registerUser(User userDetails) {
		User user = userRepo.findByUsername(userDetails.getUsername());
		
		if (user == null) {
			System.out.println("User is null");
			createUser(userDetails);
			return userRepo.findByUsername(userDetails.getUsername());
		}
		
		return null;
	}
	
}
