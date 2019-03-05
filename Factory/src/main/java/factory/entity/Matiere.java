package factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
public class Matiere {
	
	@Id
	@JsonView(JsonViews.CommonMatiere.class)
	private String titre;
	@JsonView(JsonViews.CommonMatiere.class)
	private String objectif;
	@JsonView(JsonViews.CommonMatiere.class)
	private String prerequis;
	@JsonView(JsonViews.CommonMatiere.class)
	private String contenu;
	
	@OneToMany(mappedBy="matiere")
	private List<Module> listModule;
	
	@Version
	private Integer version;
	
	@JsonView(JsonViews.CommonMatiere.class)
	@Enumerated(EnumType.STRING)
	private ENiveau niveau;


	public List<Module> getListModule() {
		return listModule;
	}

	public void setListModule(List<Module> listModule) {
		this.listModule = listModule;
	}

	public Matiere() {
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public ENiveau getNiveau() {
		return niveau;
	}

	public void setNiveau(ENiveau niveau) {
		this.niveau = niveau;
	}

}
