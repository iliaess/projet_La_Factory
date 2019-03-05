package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel{
	@JsonView(JsonViews.IMateriel.class)
	private Integer capacite;

	public Salle() {
		super();
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	
	

}
