package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class Ordinateur extends Materiel{
	
	String processeur;
	Integer ram;
	Integer hdd;
	Integer annee;
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
