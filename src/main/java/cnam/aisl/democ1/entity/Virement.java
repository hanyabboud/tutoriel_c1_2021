package cnam.aisl.democ1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "virement")
public class Virement {

	/****************** Attributs ******************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "montant")
	private double montant;
	
	@Column(name = "compte_from_id")
	private int compteFromId;
	
	@Column(name = "compte_to_id")
	private int compteToId;
	
	/****************** Getters and Setters ******************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getCompteFromId() {
		return compteFromId;
	}

	public void setCompteFromId(int compteFromId) {
		this.compteFromId = compteFromId;
	}

	public int getCompteToId() {
		return compteToId;
	}

	public void setCompteToId(int compteToId) {
		this.compteToId = compteToId;
	}

}
