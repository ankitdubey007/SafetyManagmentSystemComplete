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
import com.safety.Model.Users;
import com.safety.Repository.IncidentRepository;
import com.safety.Service.IncidentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncidentTest {
	@MockBean
	IncidentRepository repository;
	
	@Autowired
	IncidentService service;

	@Test
	 public void getAllIncidentTest() {
		 Users userId=null;
		 
		 Date incidentDate=null;
		Injury injuryId=null;
		OngoingStubbing<List<Incident>> thenReturn = when(repository.findAll()).thenReturn
				(Stream.of( new Incident(1, "collapse",incidentDate,userId, null)).collect(Collectors.toList()));       
		assertEquals(1,service.findallIncident().size());
	}
	
	@Test
	public void saveInncident() {
		Users userId=null;
		Incident incident =new Incident(1, "collapse",null,userId, null);
		when(repository.save(incident)).thenReturn(incident);
		assertEquals(incident,service.addIncident(incident));
	}

	
}
