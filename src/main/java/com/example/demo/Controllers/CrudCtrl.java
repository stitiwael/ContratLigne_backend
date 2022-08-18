package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoModels.ContratDto;
import com.example.demo.dtoModels.NodeDTO;
import com.example.demo.entities.Client;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.Node;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.services.CrudService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CrudCtrl {

	@Autowired
	private CrudService mserv;

	@GetMapping("/contrats")
	public List<Contrat> getcontrat() {
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

	@PostMapping("/create/nod")
	public Node createNode(@RequestBody NodeDTO n) {

		return mserv.addnode(n);

	}

	@GetMapping("/roles")
	public List<Role> getroles() {
		return mserv.getAllRoles();
	}

	@GetMapping("/get/contrats")
	public List<ContratDto> getallcontrats() {

		return mserv.getAllContrats();

	}

	@GetMapping("/get/clients")
	public List<Client> getAllClients() {
		return mserv.getAllClient();
	}

	@GetMapping("/get/contrat/{id}")
	public List<Contrat> getOnefromDB(@PathVariable int id) {
		return mserv.getClientContrat(id);
	}

	@GetMapping("/get/nodes")
	public List<Node> getAllNodes() {
		return mserv.getNodes();
	}

	@GetMapping("/get/nodesleveli")
	public List<Node> getLevel1Nodes() {
		return mserv.getLevelINodes();
	}

	@GetMapping("/get/nodes/{name}")
	public List<Node> getSousNodes(@PathVariable String name) {
		return mserv.getSousNodes(name);
	}
}
