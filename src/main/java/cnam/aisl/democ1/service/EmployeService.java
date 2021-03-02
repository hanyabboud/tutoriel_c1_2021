package cnam.aisl.democ1.service;

import cnam.aisl.democ1.entity.Addresse;
import cnam.aisl.democ1.entity.Client;
import cnam.aisl.democ1.entity.Compte;
import cnam.aisl.democ1.entity.Operation;

public interface EmployeService {

	public Client clientCreate(String nom, String prenom, Addresse addresse);

	public Compte compteCreate(String nom, double solde, int numeroClient);

	public Operation operationCreate(int numeroCompte, double montant, int typeOperation);
	
}
