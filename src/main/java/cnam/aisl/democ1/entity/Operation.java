package cnam.aisl.democ1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {
	
	/****************** Static ******************/
	public final static int TYPE_CREDITER = 1;
	public final static int TYPE_DEBITER = 2;
	

	/****************** Attributs ******************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date", length = 50)
	private String date;
	
	@Column(name = "montant")
	private double montant;
	
	@Column(name = "compte_id")
	private int compteId;
	
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

	public int getCompteId() {
		return compteId;
	}

	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}

}
