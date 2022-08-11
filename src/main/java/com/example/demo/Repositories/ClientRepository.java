package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	Optional<Client> findByNameIgnoreCase(String name);

}
