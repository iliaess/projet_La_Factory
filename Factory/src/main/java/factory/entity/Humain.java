package factory.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profession", discriminatorType = DiscriminatorType.STRING)
public abstract class Humain {
	@Id
	@JsonView(JsonViews.CommonHumain.class)
	@GeneratedValue
	private Long id;
	@JsonView(JsonViews.CommonHumain.class)
	private String nom;
	@JsonView(JsonViews.CommonHumain.class)
	private String prenom;
	@JsonView(JsonViews.CommonHumain.class)
	private String email;
	@JsonView(JsonViews.CommonHumain.class)
	private String telephone;
	@JsonView(JsonViews.CommonHumain.class)
	private String rue;
	@JsonView(JsonViews.CommonHumain.class)
	private String ville;
	@JsonView(JsonViews.CommonHumain.class)
	private Integer zipcode;
	
	@Version
	private Integer version;
	
	
	public Humain() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Integer getZipcode() {
		return zipcode;
	}


	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	

}
