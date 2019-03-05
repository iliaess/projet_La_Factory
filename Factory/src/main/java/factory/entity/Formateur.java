package factory.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Humain {
	@JsonView(JsonViews.CommonHumain.class)
	@OneToMany(mappedBy = "formateur")
	private List<Module> dispenses;
	@JsonView(JsonViews.CommonHumain.class)
	@OneToMany(mappedBy = "formateur")
	private List<Module> dispensables;

	public Formateur() {
		super();
	}

	public List<Module> getDispenses() {
		return dispenses;
	}

	public void setDispenses(List<Module> dispenses) {
		this.dispenses = dispenses;
	}

	public List<Module> getDispensables() {
		return dispensables;
	}

	public void setDispensables(List<Module> dispensables) {
		this.dispensables = dispensables;
	}

}
