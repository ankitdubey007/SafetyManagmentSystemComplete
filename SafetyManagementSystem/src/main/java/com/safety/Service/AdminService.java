package com.safety.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.Model.Admin;
import com.safety.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository repo;

	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return repo.save(admin);
	}



	
	public Admin admin(String adminName, String password) {
		Admin admin=repo.findByAdminNameAndPassword(adminName,password);
		return admin;
	}
	

	
	
}
