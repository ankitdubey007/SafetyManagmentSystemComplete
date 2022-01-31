package com.safety.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.Model.Incident;
import com.safety.Repository.IncidentRepository;

@Service
public class IncidentService {
	@Autowired
	IncidentRepository dao;

	public Incident addIncident(Incident incident) {
		// TODO Auto-generated method stub
		Incident inc=dao.save(incident);
		return inc;
	}

	public List<Incident> findallIncident() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Optional<Incident> findByIncidentId(int incidentId) {
		// TODO Auto-generated method stub
		return dao.findById(incidentId);
	}

	public Incident updateIncident(Incident incident) {
		// TODO Auto-generated method stub
		return dao.save(incident);
	}

	
	    






}
