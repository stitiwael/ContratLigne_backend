package com.example.demo.dto_models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContratDto {
	
    private String code_contrat;
	
	private LocalDate date_debut;
	
	private LocalDate date_fin;
	
	private String type_contrat;
	
	private String client_name;

}
