package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.TestEntity;
import com.example.demo.Entities.User;
import com.example.demo.Services.MainService;
import com.example.demo.Services.TestService;
import com.example.demo.dto_models.ContratDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MainCtrl {
	
	
	@Autowired
	private MainService mserv;
	
	
	@GetMapping("/contrats")
	public List<Contrat> getcontrat(){
		return mserv.getAllContracts();
	}
	
	@PostMapping("/create/client")
	public Client createclient(@RequestBody Client client) {
		
		return mserv.createclient(client);
		
	}
	
	@PostMapping("/create/contrat")
	public Contrat createcontrat(@RequestBody ContratDto contrat) {
		
		return mserv.createContrat(contrat);
		
	}
	
	@PostMapping("/create/user")
	public User createuser(@RequestBody User user) {
		
		return mserv.createuser(user);
		
	}
	
	
	
	@GetMapping("/roles")
	public List<Role> getroles(){
		return mserv.getAllRoles();
	}
	

	
	@GetMapping("/get/contrats")
	public List<ContratDto> getallcontrats(){
		
		return mserv.getAllContrats();
		
	}
	
	@GetMapping("/get/clients")
	public List<Client> getAllClients(){
		return mserv.getAllClient();
	}
	
	@GetMapping("/get/contrat/{id}")
	public List<Contrat> getOnefromDB(@PathVariable int id){
		return mserv.getClientContrat(id);
	}
	
	

}
