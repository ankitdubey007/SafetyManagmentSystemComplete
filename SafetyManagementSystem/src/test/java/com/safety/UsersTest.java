package com.safety;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.safety.Model.Incident;
import com.safety.Model.Rfa;
import com.safety.Model.Users;
import com.safety.Repository.UserRepository;
import com.safety.Service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {

	
	@Autowired
	UserService service;
	
	@MockBean
	UserRepository repository;
	@Test
	 public void getAllUserstest() {
		 
	when(repository.findAll()).thenReturn(Stream.of(new Users(123, "lucky"))
			.collect(Collectors.toList()));


				assertEquals(1, service.findAllUsers().size());
			}
	@Test
	public void saveUsersTest() {
		
		Users user =new Users(1, "lucky");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));
	}
	
}
