package factory.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.jsonviews.JsonViews;

@Entity(name="MATERIEL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Materiel {
	
	@Id
	@JsonView(JsonViews.CommonMateriel.class)
	@GeneratedValue
	private Long code;
	@JsonView(JsonViews.CommonMateriel.class)
	private Double cout;
	@JsonView(JsonViews.CommonMateriel.class)
	private Boolean isDispo;
	
	@Version
	private Integer version;
	
	
	
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
