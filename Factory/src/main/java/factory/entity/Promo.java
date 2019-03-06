package factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
public class Promo {

	@Id
	@GeneratedValue
	@JsonView(JsonViews.IHumainMatiereMaterielModulePromo.class)
	private Long id;
	@JsonView(JsonViews.IHumainMatiereMaterielModulePromo.class)
	private String nom;

	@OneToMany(mappedBy = "promo")
	@JsonView(JsonViews.IMatiereModulePromo.class)
	private List<Stagiaire> listStagiaire;

	@OneToMany(mappedBy = "promo")
	@JsonView(JsonViews.IPromo.class)
	private List<Module> listModule;

	@Version
	private Integer version;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Promo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Stagiaire> getListStagiaire() {
		return listStagiaire;
	}

	public void setListStagiaire(List<Stagiaire> listStagiaire) {
		this.listStagiaire = listStagiaire;
	}

	public List<Module> getListModule() {
		return listModule;
	}

	public void setListModule(List<Module> listModule) {
		this.listModule = listModule;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
