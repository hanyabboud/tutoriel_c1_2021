package cnam.aisl.democ1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cnam.aisl.democ1.entity.Compte;
import cnam.aisl.democ1.service.ClientService;

@RestController
@RequestMapping("/client")
public final class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/compte/list") 
	public List<Compte> compteList(@RequestParam("numeroClient") int numeroClient) {
		return clientService.retournerComptes(numeroClient);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/virement/create") 
	public boolean virementCreate(@RequestParam("compteFromId") int compteFromId, @RequestParam("compteToId") int compteToId, @RequestParam("solde") double solde) {
		return clientService.faireVirement(compteFromId, compteToId, solde);
	}
	
}
