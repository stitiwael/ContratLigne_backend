package com.example.demo.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.FileDb;
import com.example.demo.repositories.FileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	public FileDb uploadFile(MultipartFile file) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		 //  System.out.println(dtf.format(now));  
		
		String fileName = file.getOriginalFilename();
		FileDb filedb = new FileDb(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes(), dtf.format(now));
		return fileRepository.save(filedb);
		
	}
	
	public FileDb getFileById(String id) {
		
		Optional<FileDb> fileOptional = fileRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}
	
	public List<FileDb> getFileList() {
		
		return fileRepository.findAll();	}
	
	public FileDb updateFile(String id, MultipartFile newFile) throws IOException {
		
		
		
		FileDb fileToUpdate = getFileById(id);
		
		if(newFile != null) {
			fileToUpdate.setData(newFile.getBytes());
			fileToUpdate.setName(newFile.getOriginalFilename());
			fileToUpdate.setType(newFile.getContentType());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			fileToUpdate.setDateDeCreation(dtf.format(now));
		}
		
		return fileRepository.save(fileToUpdate);
		
		
	}
	
	

}
