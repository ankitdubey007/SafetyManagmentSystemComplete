package com.safety.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safety.Model.Admin;
import com.safety.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> addAdmin(@Validated @RequestBody Admin admin)
	{
		System.out.println("Rest");
		Admin e= adminService.addAdmin(admin);
		System.out.println(e);
		
		return new ResponseEntity<Admin>(e,HttpStatus.OK);
	}
	
	
	@GetMapping("/login")
	public ResponseEntity createAdmin(@Validated @RequestBody Admin admin)
	{
	Admin us=adminService.admin(admin.getAdminName(), admin.getPassword());
	
	if(Objects.nonNull(us))
	{
		return ResponseEntity.ok().body("Login successfully");
	}
	else
	{
		return ResponseEntity.ok().body("Incorrect adminName or password");
		
	}
	
	}



}
