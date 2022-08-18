package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.TestEntity;
import com.example.demo.services.TestService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TestCtrl {
	
	@Autowired
	private TestService testserv;
	
	@GetMapping("/test/show")
	public List<TestEntity> gettestdata(){
		
		return testserv.gettestdata();
		
		
	}
	
	@PostMapping("/test/add")
	public TestEntity add_data(@RequestBody TestEntity testentity) {
		
		return testserv.addtestdata(testentity);
	}
	
	@GetMapping("/test/{id}")
	public TestEntity getOnefromDB(@PathVariable int id){
		return testserv.getDatabyId(id);
	}
	
	
	@DeleteMapping("/test/delete/{id}")
	public boolean deleteDatabyId(@PathVariable int id) {
		
		return testserv.deletedatabyId(id);
		
		
	}
	
	

}
