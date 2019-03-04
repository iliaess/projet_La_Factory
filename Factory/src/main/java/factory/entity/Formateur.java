package factory.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Humain{
	
	@OneToMany(mappedBy="formateur")
	private List<Module> mDispenses;
	
	@OneToMany(mappedBy="formateur")
	private List<Module> mDispensables;
	
	public Formateur() {
		super();
	}
	public List<Module> getmDispenses() {
		return mDispenses;
	}
	public void setmDispenses(List<Module> mDispenses) {
		this.mDispenses = mDispenses;
	}
	public List<Module> getmDispensables() {
		return mDispensables;
	}
	public void setmDispensables(List<Module> mDispensables) {
		this.mDispensables = mDispensables;
	}
	
	
	
	

}
