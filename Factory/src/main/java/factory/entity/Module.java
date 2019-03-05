package factory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity
public class Module {
	@Id
	@GeneratedValue
	@JsonView(JsonViews.HumainMaterielMatiereModulePromo.class)
	private Long id;

	@JsonView(JsonViews.HumainMaterielMatiereModulePromo.class)
	private Date debut;
	@JsonView(JsonViews.HumainMaterielMatiereModulePromo.class)
	private Date fin;

	@ManyToOne
	@JoinColumn(name = "matiere_id")
	@JsonView(JsonViews.HumainMatiereModulePromo.class)
	private Matiere matiere;

	@ManyToOne
	@JoinColumn(name = "formateur_id")
	@JsonView(JsonViews.MaterielMatiereModulePromo.class)
	private Formateur formateur;

	@Version
	private Integer version;

	@ManyToOne
	@JoinColumn(name = "promo_id")
	@JsonView(JsonViews.HumainMaterielMatiereModule.class)
	private Promo promo;

	public Module() {
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
