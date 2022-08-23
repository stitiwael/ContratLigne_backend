package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtoModels.ContratDto;
import com.example.demo.dtoModels.NodeDTO;
import com.example.demo.entities.Client;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.Node;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ContratRepository;
import com.example.demo.repositories.NodeRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CrudService {

	@Autowired
	private ClientRepository clientRepo;
	private ContratRepository contratRepo;
	private RoleRepository roleRepo;
	private UserRepository userRepo;
	private NodeRepository nodeRepo;
	
	private ModelMapper mapper = new ModelMapper();

	

	public Client createclient(Client c) {

		return clientRepo.save(c);
		
	}

	public Client getClientbyname(String name) {

		Optional<Client> opt = clientRepo.findByNameIgnoreCase(name);
		return opt.orElseThrow(() -> new NoSuchElementException("client with this name is not found"));
	}

	public Contrat createContrat(ContratDto contrat) {

		Contrat contract = new Contrat();
		//Contrat contractt = mapper.map(contrat, Contrat.class);
		Client client = getClientbyname(contrat.getClientName());
		contract.setClient(client);
		contract.setCodeContrat(contrat.getCodeContrat());
		contract.setDateDebut(contrat.getDateDebut());
		contract.setDateFin(contrat.getDateFin());
		contract.setTypeContrat(contrat.getTypeContrat());

		return contratRepo.save(contract);

		// return contratrepo.save(c);
	}

	public User createuser(User u) {
		return userRepo.save(u);
	}

	public List<Contrat> getAllContracts() {
		return contratRepo.findAll();

	}

	public List<ContratDto> getAllContrats() {

	//	List<Contrat> lc = contratRepo.findAll();
	//	List<ContratDto> lcd = new ArrayList<>();

		//for (int i = 0; i <= lc.size() - 1; i++) {

		//	ContratDto cdto = new ContratDto();
		//	cdto.setClientName(lc.get(i).getClient().getName());
		//	cdto.setCodeContrat(lc.get(i).getCodeContrat());
		//	cdto.setDateDebut(lc.get(i).getDateDebut());
		//	cdto.setDateFin(lc.get(i).getDateFin());
		//	cdto.setTypeContrat(lc.get(i).getTypeContrat());
		//	lcd.add(cdto);
	//	}
		
	//	return lcd;
		
		return contratRepo.findAll().stream().map(co -> mapper.map(co, ContratDto.class)).collect(Collectors.toList());

	}

	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	public List<Role> getAllRoles() {
		return roleRepo.findAll();

	}

	public List<Contrat> getClientContrat(int id) {

		return clientRepo.getReferenceById(id).getList_contrats();
	}

	public Node getnodebyname(String name) {

		Optional<Node> opt = nodeRepo.findByNameIgnoreCase(name);
		return opt.orElseThrow(() -> new NoSuchElementException("node with this name is not found"));
	}

	public Node addnode(NodeDTO n) {

		Node node = new Node();

		if (!n.getParentNodeName().isEmpty()) {
			Node parentNode = nodeRepo.findByNameIgnoreCase(n.getParentNodeName()).get();
			node.setParentNode(parentNode);
		}

		node.setDateDeCreation(n.getDateDeCreation());
		node.setName(n.getName());

		if (!n.getUrl().isEmpty()) {
			node.setUrl(n.getUrl());
		}

		return nodeRepo.save(node);

	}

	public List<Node> getNodes() {

		return nodeRepo.findAll();
	}

	public List<Node> getLevelINodes() {

		// List<Node> parentNodes = noderepo.findAll();
		// parentNodes.removeIf(node -> (node.getParentNode() != null));
		// return parentNodes;
		return nodeRepo.getParentNodes();
	}

	public List<Node> getSousNodes(String name) {

		// Node parentNode = noderepo.findByNameIgnoreCase(name).get();
		// return parentNode.getSousNodes();

		return nodeRepo.getchildNodes(name);
	}

}
