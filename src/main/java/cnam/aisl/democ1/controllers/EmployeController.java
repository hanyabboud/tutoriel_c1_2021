package cnam.aisl.democ1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cnam.aisl.democ1.entity.Addresse;
import cnam.aisl.democ1.entity.Client;
import cnam.aisl.democ1.entity.Compte;
import cnam.aisl.democ1.entity.Operation;
import cnam.aisl.democ1.service.EmployeService;

@RestController
@RequestMapping("/employe")
public final class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/client/create") 
	public Client clientCreate(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, 
							   @RequestParam(value = "rue", required=false) String rue, @RequestParam(value = "codePostal", required=false) Integer codePostal, @RequestParam(value = "commune", required=false) String commune) {
		Addresse addresse = null;
		if(rue != null && codePostal != null && commune != null) {
			addresse = new Addresse();
			addresse.setCodePostal(codePostal);
			addresse.setCommune(commune);
			addresse.setRue(rue);
		}
		return employeService.clientCreate(nom, prenom, addresse);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/compte/create") 
	public Compte compteCreate(@RequestParam("nom") String nom, @RequestParam("solde") double solde, @RequestParam("numeroClient") int numeroClient) {
		return employeService.compteCreate(nom, solde, numeroClient);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operation/create") 
	public Operation operationCreate(@RequestParam("numeroCompte") int numeroCompte, @RequestParam("montant") double montant, @RequestParam("typeOperation") int typeOperation) {
		return employeService.operationCreate(numeroCompte, montant, typeOperation);
	}
	
}
