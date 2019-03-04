package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import factory.entity.Ordinateur;

@Entity
@DiscriminatorValue("S")
public class Stagiaire extends Humain {
	Ordinateur ordinateur;
	
	public Stagiaire() {
		super();
	}
	

}
