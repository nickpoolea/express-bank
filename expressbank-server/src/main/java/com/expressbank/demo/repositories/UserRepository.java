package com.expressbank.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expressbank.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}