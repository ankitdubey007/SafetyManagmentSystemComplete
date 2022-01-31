package com.safety.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;
	
	private String adminName;
	private String password;

	//private long adminId;
	

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	@Override
	public String toString() {
		return "Admin [AdminId=" +adminId + ", adminName=" + adminName + ", password=" + password +  "]";
	}

	public Admin(long adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
