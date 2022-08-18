package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Node {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(nullable = true)
	private String url;
	
	
	private LocalDate dateDeCreation;
	
	@ManyToOne
	@JoinColumn(name = "parentNode", nullable = true)
	@JsonIgnore
	private Node parentNode;
	
	@OneToMany(mappedBy = "parentNode", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Node> sousNodes = new ArrayList<>();

	
	
	

}
