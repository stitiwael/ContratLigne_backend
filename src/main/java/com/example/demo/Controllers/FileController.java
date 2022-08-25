package com.example.demo.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtoModels.FileVersionMetadataDto;
import com.example.demo.entities.FileDb;
import com.example.demo.entities.FileVersionMetadata;
import com.example.demo.services.CrudService;
import com.example.demo.services.FileService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {
	
	
	FileService fileService;
	
	
	@PostMapping("/file/upload")
	public FileDb UploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		return fileService.uploadFile(file);
		
	}
	
	@PostMapping("/file/add/metadata")
	public FileVersionMetadata addMetadata(@RequestBody List<FileVersionMetadataDto> fvmd) {
		for(int i = 0 ; i<= fvmd.size() - 1; i++) {
		fileService.addMetadata(fvmd.get(i));
		}
		
		return null;
	}
	
	@GetMapping("/file/getall")
	public List<FileDb> getAllFiles(){
		return this.fileService.getFileList();
	}
	
	
	@PutMapping("/file/update/{id}")
	public FileDb updateFile(@PathVariable String id, @RequestParam("file") MultipartFile newFile) throws IOException {
		return fileService.updateFile(id, newFile);
	}
	

}
