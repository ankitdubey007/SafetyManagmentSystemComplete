package com.safety.Service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.Model.Users;
import com.safety.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
	UserRepository repo;
	
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		
		return  repo.save(user);
	}

	public Users findById(int id) {
		// TODO Auto-generated method stub
		Optional<Users> user =repo.findById(id);
		return user.get();
	}

	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
 
}
