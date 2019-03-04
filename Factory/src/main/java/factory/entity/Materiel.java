package factory.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity(name="MATERIEL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Materiel {
	
	@Id
	Long code;
	Double cout;
	Boolean isDispo;
	
	@Version
	Integer version;
	
	
	
	public Materiel() {
		
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Double getCout() {
		return cout;
	}
	public void setCout(Double cout) {
		this.cout = cout;
	}
	public Boolean getIsDispo() {
		return isDispo;
	}
	public void setIsDispo(Boolean isDispo) {
		this.isDispo = isDispo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	

	
	
}
