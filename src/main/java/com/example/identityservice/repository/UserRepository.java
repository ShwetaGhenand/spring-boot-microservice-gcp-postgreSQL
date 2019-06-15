package com.example.identityservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.identityservice.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByFirstName(String FirstName);
	List<User> findAll();


}
