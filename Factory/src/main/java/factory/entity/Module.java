package factory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Module {
	@Id
	@GeneratedValue
	private Long id;
	
	private Eniveau niveau;
	
	private Date debut;
	private Date fin;
	
	
	@ManyToOne
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="formateur_id")
	private Formateur formateur;
	
	@Version
	private Integer version;
	
	@ManyToOne
	@JoinColumn(name="promo_id")
	private Promo promo;

	public Module() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Eniveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Eniveau niveau) {
		this.niveau = niveau;
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
