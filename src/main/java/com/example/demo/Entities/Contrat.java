package com.example.demo.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Contrat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	@Column(unique = true)
	private String code_contrat;
	
	private LocalDate date_debut;
	
	private LocalDate date_fin;
	
	private String type_contrat;
	
	
	@JsonIgnore
	@ManyToOne
	private Client client;

}
