package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
