package com.safety.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.Model.Incident;
import com.safety.Model.Rfa;
import com.safety.Model.Users;
import com.safety.Repository.RfaRepository;

@Service
public class RfaService {
    @Autowired
	RfaRepository repo;
	public Rfa addRfa(Rfa rfa) {
		// TODO Auto-generated method stub
		return repo.save(rfa);
	}
	public List<Rfa> findallRfa() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public Rfa updateRfa(int rfaId, Rfa rfa) {
		// TODO Auto-generated method stub
		return repo.save(rfa);
	}
	public Optional<Rfa> findByRfaId(int rfaId) {
		// TODO Auto-generated method stub
		return repo.findById(rfaId);
	}
	

	
	







	

}
