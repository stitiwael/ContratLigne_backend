package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
