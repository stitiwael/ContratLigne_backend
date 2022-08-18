package com.example.demo.dtoModels;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContratDto {
	
    private String codeContrat;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	private String typeContrat;
	
	private String clientName;

}
