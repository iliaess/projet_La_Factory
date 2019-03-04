package factory.entity;

import java.util.Date;
import java.util.List;
import factory.entity.Matiere;
import factory.entity.Formateur;
import factory.entity.Eniveau;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Module {
	@Id
	Long id;
	
	@Enumerated
	List<Eniveau> niveau;
	
	Date debut;
	Date fin;
	
	Matiere matiere;
	
	Formateur formateur;
	
	@Version
	Integer version;

	public Module() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Eniveau> getNiveau() {
		return niveau;
	}

	public void setNiveau(List<Eniveau> niveau) {
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
