package com.safety.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.Model.Incident;
import com.safety.Model.Injury;
import com.safety.Repository.InjuryRepository;

@Service
public class InjuryService {
   
	@Autowired
	InjuryRepository repo;
	
	
	public Injury addInjury(Injury injury) {
		
			// TODO Auto-generated method stub
			Injury inj=repo.save(injury);
			return inj;
		}


	public List<Injury> findallInjury() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public Optional<Injury> findByInjuryId(int injuryId) {
		// TODO Auto-generated method stub
		return repo.findById(injuryId);
	}


	public Injury updateInjury(Injury injury) {
		// TODO Auto-generated method stub
		return repo.save(injury);
	}



		
	}
	

