package com.example.demo.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.TestEntity;
import com.example.demo.Repositories.TestRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TestService {
	
	@Autowired
	private TestRepository testrepos;
	
	public List<TestEntity> gettestdata() {
		
		return testrepos.findAll();
	}
	
	public TestEntity addtestdata(TestEntity testentity) {
		
		return testrepos.save(testentity);
		
	}
	
	public TestEntity getDatabyId(int id) {
		
		Optional<TestEntity> t= testrepos.findById(id);
		
		return t.orElseThrow(()->new NoSuchElementException("Data with this id is not found"));
	}
	
	
	public boolean deletedatabyId(int id) {
		
		TestEntity t = getDatabyId(id);
		
		if(t!=null) {
			testrepos.deleteById(id);
			return true;
		}
		return true;
		
	}
	
	public TestEntity updatebyID(int id, TestEntity newtest) {
		
		TestEntity t = getDatabyId(id);
		if(newtest.getDumpdata()!=null)
			t.setDumpdata(newtest.getDumpdata());
		
		return testrepos.save(t);
		
	}

}
