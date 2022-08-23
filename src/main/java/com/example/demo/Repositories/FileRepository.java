package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FileDb;

public interface FileRepository extends JpaRepository<FileDb, String> {
	
	

}
