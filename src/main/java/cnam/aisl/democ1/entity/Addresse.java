package cnam.aisl.democ1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresse")
public class Addresse {

	/****************** Attributs ******************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int numeroDansLaRue;
	
	@Column(name = "rue", length = 100)
	private String rue;
	
	@Column(name = "code_postal")
	private int codePostal;
	
	@Column(name = "commune", length = 100)
	private String commune;

	/****************** Getters and Setters ******************/
	
	public int getNumeroDansLaRue() {
		return numeroDansLaRue;
	}

	public void setNumeroDansLaRue(int numeroDansLaRue) {
		this.numeroDansLaRue = numeroDansLaRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

}
