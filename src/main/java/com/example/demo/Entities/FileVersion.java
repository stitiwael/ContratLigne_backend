package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class FileVersion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String versionNumber;
	
	private String date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="file_id",referencedColumnName="id")
	private FileDb file;
	
	
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<FileVersionMetadata> fileVersionMetadata = new ArrayList<>();
	
	
	/*
	 * @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	 * 
	 * @JoinColumn(name="fileVersionMetadata") private FileVersionMetadata
	 * fileVersionMetadata;
	 */
	
	
	
	

}
