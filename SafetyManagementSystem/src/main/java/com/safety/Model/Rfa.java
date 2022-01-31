package com.safety.Model;

import java.util.List;
import java.util.stream.Collector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="rfa")
public class Rfa {

	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int rfaId;
		
		@NotEmpty(message="request field should not be empty..")
		@Column(name="request",nullable = false)
		private String request;
		
		@NotEmpty(message="reason field should not be empty..")
		@Column(name="reason_for_request",nullable = false)
		private String reason;
		@ManyToOne
		@JsonBackReference(value = "user-rfa")
		private Users user;
		

	
		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public int getRfaId() {
			return rfaId;
		}

		public void setRfaId(int rfaId) {
			this.rfaId = rfaId;
		}

		public String getRequest() {
			return request;
		}

		public void setRequest(String request) {
			this.request = request;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		@Override
		public String toString() {
			return "Rfa [rfaId=" + rfaId + ", request=" + request + ", reason=" + reason + ", user=" + user
					+ "]";
		}

		public Rfa(int rfaId, @NotEmpty(message = "request field should not be empty..") String request,
				@NotEmpty(message = "reason field should not be empty..") String reason, Users user) {
			super();
			this.rfaId = rfaId;
			this.request = request;
			this.reason = reason;
			this.user = user;
		}

		public Rfa() {
			super();
			// TODO Auto-generated constructor stub
		}

		




		
		
	}

	


