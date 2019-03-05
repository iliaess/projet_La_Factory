package factory.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Humain {
	@JsonView(JsonViews.HumainMaterielMatierePromo.class)
	@OneToMany(mappedBy = "formateur")
	private List<Module> dispenses;
	@JsonView(JsonViews.HumainMaterielModulePromo.class)
	@ManyToMany
	@JoinTable(name = "Dispensables_Formateurs", 
	joinColumns = @JoinColumn(name = "formateur_id"), 
	inverseJoinColumns = @JoinColumn(name = "matiere_titre"))
	private List<Matiere> dispensables;

	public Formateur() {
		super();
	}

	public List<Module> getDispenses() {
		return dispenses;
	}

	public void setDispenses(List<Module> dispenses) {
		this.dispenses = dispenses;
	}

	public List<Matiere> getDispensables() {
		return dispensables;
	}

	public void setDispensables(List<Matiere> dispensables) {
		this.dispensables = dispensables;
	}

}
