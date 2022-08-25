package com.example.demo.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.LastModified;

import com.example.demo.dtoModels.FileVersionMetadataDto;
import com.example.demo.entities.FileDb;
import com.example.demo.entities.FileVersion;
import com.example.demo.entities.FileVersionMetadata;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.FileVersionMetadataRepository;
import com.example.demo.repositories.FileVersionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	FileVersionRepository fileVersionRepository;
	
	@Autowired
	FileVersionMetadataRepository fileVersionMetadataRepo;
	
	public FileDb uploadFile(MultipartFile file) throws IOException {
		if(file!=null) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		 //  System.out.println(dtf.format(now));  
		
		String fileName = file.getOriginalFilename();
		FileDb filedb = new FileDb(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes(), dtf.format(now));
		FileVersion nfileVersion = new FileVersion();
		//List<FileVersionMetadata> nlfvm = null;
		/*
		 * for(int i = 0 ; i <= fvm.size(); i++) { FileVersionMetadata nfvm = new
		 * FileVersionMetadata(); nfvm.setKeyy(fvm.get(i).getKeyy());
		 * nfvm.setValue(fvm.get(i).getValue()); nlfvm.add(nfvm); }
		 */
		
		
		fileRepository.save(filedb); 
		nfileVersion.setDate(dtf.format(now));
		nfileVersion.setVersionNumber("1");
		nfileVersion.setFile(filedb);
		//nfileVersion.setFileVersionMetadata(nlfvm);
		fileVersionRepository.save(nfileVersion);
		/*
		 * for(int i = 0 ; i <= nlfvm.size(); i++) {
		 * fileVersionMetadataRepo.save(nlfvm.get(i)); }
		 */
		return filedb;
		
		}
		
		return null;
		
	}
	
	public FileVersionMetadata addMetadata(FileVersionMetadataDto fvmd) {
		
		FileVersionMetadata nfvm = new FileVersionMetadata();
		FileVersion fv = fileVersionRepository.getReferenceById(fvmd.getVersionId());
		nfvm.setFileVersion(fv);
		nfvm.setKeyy(fvmd.getKeyy());
		nfvm.setValue(fvmd.getValue());
		
		return fileVersionMetadataRepo.save(nfvm);
		
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
		FileVersion nfileVersion = new FileVersion();
		
		if(newFile != null) {
			fileToUpdate.setData(newFile.getBytes());
			fileToUpdate.setName(newFile.getOriginalFilename());
			fileToUpdate.setType(newFile.getContentType());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			fileToUpdate.setDateDeCreation(dtf.format(now));
			
			
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//int t = fileRepository.getById(id).getFileVersions().size();
		//String v = fileToUpdate.getFileVersions().get(t).getVersionNumber()+"1";
		nfileVersion.setVersionNumber("1.1");
		nfileVersion.setDate(dtf.format(now));
		
		
		fileRepository.save(fileToUpdate);
		nfileVersion.setFile(fileToUpdate);
		fileVersionRepository.save(nfileVersion);
		return fileToUpdate;
		
		
		
	}
	
	
	
	

}
