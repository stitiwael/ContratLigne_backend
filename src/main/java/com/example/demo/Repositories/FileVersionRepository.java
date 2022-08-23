package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FileVersion;

public interface FileVersionRepository extends JpaRepository<FileVersion, Integer> {

}
