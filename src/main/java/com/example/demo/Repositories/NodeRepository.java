package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Node;

public interface NodeRepository extends JpaRepository<Node, Integer> {
	
	Optional<Node> findByNameIgnoreCase(String name);
	
	@Query(value = "Select n from Node n where n.parentNode is null", nativeQuery = false)
	List<Node> getParentNodes();
	
	@Query(value = "Select n from Node n where n.parentNode.name = :name", nativeQuery = false)
	List<Node> getchildNodes(@Param("name") String name);
	
}
