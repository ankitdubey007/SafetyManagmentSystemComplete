package com.safety;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
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
import com.safety.Repository.InjuryRepository;
import com.safety.Service.IncidentService;
import com.safety.Service.InjuryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjuryTest {

@Autowired
private InjuryService service;

@MockBean
private InjuryRepository repository;

//fetchAllInjury

@Test
 public void getInjuryAddTest() {
	 Users userId=null;
	
	OngoingStubbing<List<Injury>> thenReturn = when(repository.findAll()).thenReturn
			(Stream.of( new Injury(1, "burnt",userId)).collect(Collectors.toList()));       
	assertEquals(1,service.findallInjury().size());
}

////addInjury

@Test
public void saveInjury() {
	Users userId=null;
	Injury injury=new Injury(1, "burnt", userId);
	when(repository.save(injury)).thenReturn(injury);
	assertEquals(injury,service.addInjury(injury));
}


}

