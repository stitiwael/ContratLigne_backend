package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FileVersionMetadata;

public interface FileVersionMetadataRepository extends JpaRepository<FileVersionMetadata, Integer> {

}
