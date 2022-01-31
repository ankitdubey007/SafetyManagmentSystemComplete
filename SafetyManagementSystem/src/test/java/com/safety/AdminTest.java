package com.safety;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.safety.Model.Admin;
import com.safety.Model.Incident;
import com.safety.Model.Injury;
import com.safety.Model.Users;
import com.safety.Repository.AdminRepository;
import com.safety.Service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {

	@Autowired
	AdminService service;
	
	@MockBean
	AdminRepository repository;
	
	@Test
	public void saveAdminTest() {
		
		Admin admin =new Admin(1, "lucky","luck@123");
		when(repository.save(admin)).thenReturn(admin);
		assertEquals(admin,service.addAdmin(admin));
	}
	
	
}
