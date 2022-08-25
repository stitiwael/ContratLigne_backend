package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Files")
public class FileDb {
	
	@Id
	private String id;
	
	private String name;
	
	private String type;
	
	@Lob
	private byte[] data;
	
	private String dateDeCreation;
	
    @OneToMany(cascade = CascadeType.ALL)
    private List<FileVersion> fileVersions = new ArrayList<>();
	

	public FileDb() {
		super();
	}



	public FileDb(String id, String name, String type, byte[] data, String dateDeCreation) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
		this.dateDeCreation = dateDeCreation;
	}



	
	
	
	
	

}
