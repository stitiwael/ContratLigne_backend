package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	Optional<Client> findByNameIgnoreCase(String name);

}
