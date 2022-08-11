package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.ClientRepository;
import com.example.demo.Repositories.ContratRepository;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto_models.ContratDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MainService {
	
	@Autowired
	private ClientRepository clientrepo;
	private ContratRepository contratrepo;
	private RoleRepository rolerepo;
	private UserRepository userrepo;
	
	
	
	
	public Client createclient(Client c) {
		
		return clientrepo.save(c);
	}
	
	public Client getemployeebyname(String name) {
		
		Optional<Client> opt = clientrepo.findByNameIgnoreCase(name);
		return opt.orElseThrow(()->new NoSuchElementException("client with this name is not found"));
	}
	
	public Contrat createContrat(ContratDto contrat) {
		
		Contrat contract = new Contrat();
		
		Client client = getemployeebyname(contrat.getClient_name());
		
		contract.setClient(client);
		contract.setCode_contrat(contrat.getCode_contrat());
		contract.setDate_debut(contrat.getDate_debut());
		contract.setDate_fin(contrat.getDate_fin());
		contract.setType_contrat(contrat.getType_contrat());
		
		return contratrepo.save(contract);
		
		
		
	//	return contratrepo.save(c);
	}
	
	public User createuser(User u) {
		return userrepo.save(u);
	}
	
	public List<Contrat> getAllContracts(){
		return contratrepo.findAll();
		
				}
	
	public List<ContratDto> getAllContrats(){
		
		List<Contrat> lc = contratrepo.findAll();
		List<ContratDto> lcd = new ArrayList<>();
		
		
        for(int i = 0 ; i <= lc.size()-1 ; i++) {
        	
        ContratDto cdto = new ContratDto();
		cdto.setClient_name(lc.get(i).getClient().getName());	
		cdto.setCode_contrat(lc.get(i).getCode_contrat());
		cdto.setDate_debut(lc.get(i).getDate_debut());
		cdto.setDate_fin(lc.get(i).getDate_fin());
		cdto.setType_contrat(lc.get(i).getType_contrat());
		lcd.add(cdto);
		}
		
		return lcd;
		
		
	}
	
	public List<Client> getAllClient(){
		return clientrepo.findAll();
	}
	
	
	public List<Role> getAllRoles(){
		return rolerepo.findAll();
		
				}
	
	public List<Contrat> getClientContrat(int id){
		
		List<Contrat> lc = clientrepo.getById(id).getList_contrats();
		return lc;
		
	}
	
	

}
