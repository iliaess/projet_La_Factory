package factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class Gestionnaire extends Humain {
	
	
	public Gestionnaire() {
		super();
	}
	
	
	

}
