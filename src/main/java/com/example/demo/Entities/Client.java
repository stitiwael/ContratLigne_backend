package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String adresse;
	
	private String lastName;
	
	private String phoneNumber;
	
	@OneToMany(mappedBy = "client")
	private List<Contrat> list_contrats;
	
	
	
	
}
