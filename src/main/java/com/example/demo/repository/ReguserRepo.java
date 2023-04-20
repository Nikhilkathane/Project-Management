package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reguser;

public interface ReguserRepo extends JpaRepository<Reguser, Integer> {

	
	int countByUsername(String username);
	
	
	
	
Reguser findByUsername(String username);



}
