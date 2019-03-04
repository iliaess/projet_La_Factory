package factory.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import factory.entity.Ordinateur;

@Entity
@DiscriminatorValue("S")
public class Stagiaire extends Humain {
	
	

	@OneToOne
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="promo_id")
	private Promo promo;
	
	
	public Stagiaire() {
		super();
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	
	

}
