package com.safety.Repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.safety.Model.Rfa;

public interface RfaRepository extends JpaRepository<Rfa, Integer> {
	@Modifying
	@Query("update Rfa r set  r.request = inputRequest,r.reason=inputReason  ")
	void setRfa(String request,String reason);



}
