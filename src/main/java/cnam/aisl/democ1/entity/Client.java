package cnam.aisl.democ1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "client")
public class Client {

	/****************** Attributs ******************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int numeroClient;
	
	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;
	
	/****************** Jointures ******************/
	
	@OneToMany(mappedBy="clientId")
	private List<Compte> comptes;
	
	@OneToOne
	@JoinColumn(name="addresse_id", referencedColumnName="id", nullable=true)
	private Addresse addresse;
	
	/****************** Getters and Setters ******************/
	
	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Addresse getAddresse() {
		return addresse;
	}

	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
