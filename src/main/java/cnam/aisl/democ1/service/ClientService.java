package cnam.aisl.democ1.service;

import java.util.List;
import cnam.aisl.democ1.entity.Compte;

public interface ClientService {

	public List<Compte> retournerComptes(int numeroClient);
	
	public boolean faireVirement(int compteFromId, int compteToId, double solde);
	
}
