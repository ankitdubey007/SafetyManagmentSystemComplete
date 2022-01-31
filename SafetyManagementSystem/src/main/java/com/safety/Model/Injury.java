package com.safety.Model;


import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Optional;



@Entity
@Table(name="injury")
public class Injury {


		   @Id
		   @GeneratedValue(strategy = GenerationType.AUTO)
		   private int injuryId;
		   @Column(name="injuryInfo",nullable=false)
		   @NotEmpty(message="injuryInfo should not be empty.")
		   private String injuryInfo;
		   
		   @ManyToOne
		   @JsonBackReference(value = "user-injury")
	       private Users user;
		   
		   @OneToMany(mappedBy = "injury",cascade = CascadeType.ALL)
		   @JsonManagedReference(value = "injury-incident")
		   private List<Incident> incident;

		




		public int getInjuryId() {
			return injuryId;
		}

		public void setInjuryId(int injuryId) {
			this.injuryId = injuryId;
		}

		public String getInjuryInfo() {
			return injuryInfo;
		}

		public void setInjuryInfo(String injuryInfo) {
			this.injuryInfo = injuryInfo;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public Injury(int injuryId, @NotEmpty(message = "injuryInfo should not be empty.") String injuryInfo,
				Users user) {
			super();
			this.injuryId = injuryId;
			this.injuryInfo = injuryInfo;
			this.user = user;
		}

		@Override
		public String toString() {
			return "Injury [injuryId=" + injuryId + ", injuryInfo=" + injuryInfo + ", user=" + user + ", incident="
					+ incident + "]";
		}

		public Injury() {
			super();
			// TODO Auto-generated constructor stub
		}
    
		
		

	
		
	
		   
		   
	

	}


