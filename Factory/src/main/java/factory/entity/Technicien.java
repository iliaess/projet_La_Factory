package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class Technicien extends Humain {
	
	public Technicien() {
		super();
	}

}
