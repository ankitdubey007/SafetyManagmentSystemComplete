package com.safety.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.safety.Model.Injury;

public interface InjuryRepository extends JpaRepository<Injury, Integer>{
	@Modifying
	@Query("update Injury i set i.injuryInfo=inputInjuryInfo   ")
	void setIncident(String incidentInfo);

	

//	Injury save(Injury injury);

}
