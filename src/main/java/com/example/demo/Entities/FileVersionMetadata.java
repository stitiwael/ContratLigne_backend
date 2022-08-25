package com.example.demo.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

import com.example.demo.configuration.JsonToMapConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class FileVersionMetadata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	private String keyy;
	
	private String value;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn (name="file_version_id",referencedColumnName="id")
	private FileVersion fileVersion;
	
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy = "fileVersionMetadata") private FileVersion fileVersion;
	 */
	
	/*
	 * @ElementCollection
	 * 
	 * @Column(name = "value", columnDefinition = "json")
	 * 
	 * @Convert(attributeName = "key", converter = JsonToMapConverter.class) private
	 * Map<String, Object> metaData = new HashMap<>();
	 */

}
