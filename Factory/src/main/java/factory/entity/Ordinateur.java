package factory.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("O")
public class Ordinateur extends Materiel{
	@JsonView(JsonViews.CommonMateriel.class)
	private String processeur;
	@JsonView(JsonViews.CommonMateriel.class)
	private Integer ram;
	@JsonView(JsonViews.CommonMateriel.class)
	private Integer hdd;
	@JsonView(JsonViews.CommonMateriel.class)
	private Integer annee;
	@JsonView(JsonViews.CommonMateriel.class)
	@OneToOne(mappedBy="ordinateur")
	private Stagiaire stagiaire;
	
	
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	public Ordinateur() {
		// TODO Auto-generated constructor stub
	}
	public String getProcesseur() {
		return processeur;
	}
	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getHdd() {
		return hdd;
	}
	public void setHdd(Integer hdd) {
		this.hdd = hdd;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	
	
	
	
	

}
