package cnam.aisl.democ1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
public class Compte {

	/****************** Attributs ******************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int numeroCompte;

	@Column(name = "nom", length = 50)
	private String nom;
	
	@Column(name = "solde")
	private double solde;
	
	@Column(name = "client_id")
	private int clientId;
	
	/****************** Jointures ******************/
	
	@OneToMany(mappedBy="compteFromId")
	private List<Virement> virementsFrom;
	
	@OneToMany(mappedBy="compteToId")
	private List<Virement> virementsTo;
	
	@OneToMany(mappedBy="compteId")
	private List<Operation> operations;
	
	/****************** Getters and Setters ******************/

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public List<Virement> getVirementsFrom() {
		return virementsFrom;
	}

	public void setVirementsFrom(List<Virement> virementsFrom) {
		this.virementsFrom = virementsFrom;
	}

	public List<Virement> getVirementsTo() {
		return virementsTo;
	}

	public void setVirementsTo(List<Virement> virementsTo) {
		this.virementsTo = virementsTo;
	}
	
}
