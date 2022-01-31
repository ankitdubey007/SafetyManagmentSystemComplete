package com.safety.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.safety.Model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	


	Admin findByAdminNameAndPassword(String adminName, String password);

	
		
	

}
