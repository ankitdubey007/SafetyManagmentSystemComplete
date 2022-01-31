package com.safety.Model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="incident")
public class Incident {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incidentId;
	@NotEmpty(message="incidentinfo should not be empty.")
	private String incidentInfo;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
	private Date incidentDate;
    

	@ManyToOne
	@JsonBackReference(value = "user-incident")
  private Users user;
	
	@ManyToOne
	@JsonBackReference(value = "injury-incident")
	private Injury injury;
	
	
  
	
	
	public Injury getInjury() {
		return injury;
	}
	public void setInjury(Injury injury) {
		this.injury = injury;
	}
	public Users getUser() {
	return user;
}
public void setUser(Users user) {
	this.user = user;
}
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	public String getIncidentInfo() {
		return incidentInfo;
	}
	public void setIncidentInfo(String incidentInfo) {
		this.incidentInfo = incidentInfo;
	}
	
	public Date getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}
	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", incidentInfo=" + incidentInfo + ", incidentDate="
				+ incidentDate + ", user=" + user + "]";
	}

	
	public Incident(int incidentId, @NotEmpty(message = "incidentinfo should not be empty.") String incidentInfo,
			Date incidentDate, Users user, Injury injury) {
		super();
		this.incidentId = incidentId;
		this.incidentInfo = incidentInfo;
		this.incidentDate = incidentDate;
		this.user = user;
		this.injury = injury;
	}
	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
	

	
	
	

