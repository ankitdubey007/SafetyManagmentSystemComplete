package com.safety.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class Users {

@Id
@Column(nullable = false)
private int userId;
private String userName;


@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonManagedReference(value = "user-incident")
private List<Incident> incident;

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonManagedReference(value = "user-injury")
private List<Injury> injury;
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonManagedReference(value = "user-rfa")
private List<Rfa> rfa;


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "Users [userId=" + userId + ", userName=" + userName + ", incident=" + incident + "]";
}

public Users(int userId, String userName) {
	super();
	this.userId = userId;
	this.userName = userName;
}
public Users() {
	super();
	// TODO Auto-generated constructor stub
}




}