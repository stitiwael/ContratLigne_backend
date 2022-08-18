package com.example.demo.dtoModels;

import java.time.LocalDate;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class NodeDTO {

	private String url;
	private String name;
	private LocalDate dateDeCreation;
	private String parentNodeName;

}
