package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("P")
public class Projecteur extends Materiel{
	@JsonView(JsonViews.CommonMateriel.class)
	private String resolution;

	public Projecteur() {
	
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	

}
