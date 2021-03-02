package cnam.aisl.democ1.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cnam.aisl.democ1.entity.Client;
import cnam.aisl.democ1.entity.Compte;
import cnam.aisl.democ1.entity.Operation;
import cnam.aisl.democ1.entity.Virement;
import cnam.aisl.democ1.repository.ClientRepository;
import cnam.aisl.democ1.repository.CompteRepository;
import cnam.aisl.democ1.repository.OperationRepository;
import cnam.aisl.democ1.repository.VirementRepository;
import cnam.aisl.democ1.service.ClientService;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private VirementRepository virementRepository;

	public List<Compte> retournerComptes(int numeroClient) {
		List<Compte> res = null;
		try {
			Client client = clientRepository.findById(numeroClient).get();
			res = client.getComptes();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean faireVirement(int compteFromId, int compteToId, double solde) {
		boolean res = false;
		try {
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			Compte compteFrom = compteRepository.findById(compteFromId).get();
			Compte compteTo = compteRepository.findById(compteToId).get();
			
			boolean debitOperation = operationCreatePourVirement(solde, compteFrom, date, Operation.TYPE_DEBITER);
			if(debitOperation) {
				res = operationCreatePourVirement(solde, compteTo, date, Operation.TYPE_CREDITER);
				if(!res) operationCreatePourVirement(solde, compteFrom, date, Operation.TYPE_CREDITER);
				else {
					Virement virement = new Virement();
					virement.setDate(date);
					virement.setMontant(solde);
					virement.setCompteFromId(compteFromId);
					virement.setCompteToId(compteToId);
					virementRepository.save(virement);
				}
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean operationCreatePourVirement(double montant, Compte compte, String date, int typeOperation) {
		boolean res = false;
		try {
			// Changer le montant celon le type d'operation
			if(typeOperation == Operation.TYPE_DEBITER) montant *= -1;
			
			// Create Operation
			Operation operation = new Operation();
			operation.setDate(date);
			operation.setMontant(montant);
			operation.setCompteId(compte.getNumeroCompte());
			
			double nouveauMontant = compte.getSolde() + montant;
			if(nouveauMontant >= 0) {
				compte.setSolde(nouveauMontant);
				compteRepository.save(compte);
				operationRepository.save(operation);
				res = true;
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return res;
	}

}
