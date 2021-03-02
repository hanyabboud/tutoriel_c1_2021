package cnam.aisl.democ1.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cnam.aisl.democ1.entity.Addresse;
import cnam.aisl.democ1.entity.Client;
import cnam.aisl.democ1.entity.Compte;
import cnam.aisl.democ1.entity.Operation;
import cnam.aisl.democ1.repository.AddresseRepository;
import cnam.aisl.democ1.repository.ClientRepository;
import cnam.aisl.democ1.repository.CompteRepository;
import cnam.aisl.democ1.repository.OperationRepository;
import cnam.aisl.democ1.service.EmployeService;

@Service("EmployeService")
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddresseRepository addresseRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Client clientCreate(String nom, String prenom, Addresse addresse) {
		Client client = null;
		try {
			// Create Client
			client = new Client();
			client.setNom(nom);
			client.setPrenom(prenom);
			
			clientRepository.save(client);
			
			// Create Addresse
			addresseRepository.save(addresse);
			
			// Update Client Addresse
			client.setAddresse(addresse);
			clientRepository.save(client);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public Compte compteCreate(String nom, double solde, int numeroClient) {
		Compte compte = null;
		try {
			// Create Compte
			compte = new Compte();
			compte.setNom(nom);
			compte.setSolde(solde);
			compte.setClientId(numeroClient);
			
			compteRepository.save(compte);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public Operation operationCreate(int numeroCompte, double montant, int typeOperation) {
		Operation operation = null;
		try {
			// Get Client by id
			Compte compte = compteRepository.findById(numeroCompte).get();
			
			// Creation Date
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			// Changer le montant celon le type d'operation
			if(typeOperation == Operation.TYPE_DEBITER) montant *= -1;
			
			// Create Operation
			operation = new Operation();
			operation.setDate(date);
			operation.setMontant(montant);
			operation.setCompteId(compte.getNumeroCompte());
			
			double nouveauSolde = compte.getSolde() + montant;
			if(nouveauSolde >= 0) {
				compte.setSolde(nouveauSolde);
				compteRepository.save(compte);
				operationRepository.save(operation);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return operation;
	}
	
}
