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


import com.safety.Model.Incident;
import com.safety.Model.Injury;
import com.safety.Model.Rfa;
import com.safety.Model.Users;
import com.safety.Repository.RfaRepository;
import com.safety.Service.RfaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RfaTest {

	@Autowired
	RfaService service;
	
	@MockBean
	RfaRepository repository;
	
	
	@Test
	 public void getAllRfaTest() {
		 Users userId=null;
	when(repository.findAll()).thenReturn(Stream.of(new Rfa(123, "change", "reques",null))
			.collect(Collectors.toList()));


				assertEquals(1, service.findallRfa().size());
			}
	
	@Test
	public void saveInncident() {
		Users userId=null;
		Rfa rfa =new Rfa(1, "reason","request",userId);
		when(repository.save(rfa)).thenReturn(rfa);
		assertEquals(rfa,service.addRfa(rfa));
	}

	
}
