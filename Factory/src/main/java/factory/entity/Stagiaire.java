package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import factory.entity.Ordinateur;
import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("S")
public class Stagiaire extends Humain {
	
	
	@JsonView(JsonViews.CommonHumain.class)
	@OneToOne(fetch = FetchType.EAGER)
	private Ordinateur ordinateur;
	
	@JsonView(JsonViews.CommonHumain.class)
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
