package com.safety.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safety.Exception.RecordNotFoundException;
import com.safety.Model.Incident;
import com.safety.Model.Injury;
import com.safety.Model.Rfa;
import com.safety.Model.Users;
import com.safety.Service.RfaService;
import com.safety.Service.UserService;

@RestController
@RequestMapping("/rfa")
public class RfaRestController {

	@Autowired
	RfaService rfaService;
	@Autowired
	UserService userService;

	
	@PostMapping("/addRfa")
	public Rfa addRfa(@Validated @RequestBody Rfa rfa){
		
		 Users userResponse =userService.findById(rfa.getUser().getUserId());
         rfa.setUser(userResponse);
		return rfaService.addRfa(rfa);
	}
	
	@PutMapping("/{rfaId}")
	public ResponseEntity<Rfa> updateRfa(@PathVariable int rfaId,@RequestBody Rfa rfa){
		
		Rfa r = rfaService.updateRfa(rfaId,rfa);
		return new ResponseEntity<Rfa>(r,HttpStatus.OK);
	}

	@GetMapping("/fetchAllRfa")
	public ResponseEntity<List<Rfa>> fetchRfa(){
		
		List<Rfa> r = rfaService.findallRfa();
		return ResponseEntity.ok().body(r);
	}
    @GetMapping("/{rfaId}")
    
	public ResponseEntity<List<Rfa>> getRfaById(@PathVariable int rfaId){
	
	Optional<Rfa> rfa = rfaService.findByRfaId(rfaId);
	if(rfa.isPresent()) {
		return new ResponseEntity(rfa.get(), HttpStatus.OK);
	}
	else {
		throw new RecordNotFoundException("Record not found...");
	}
		
	}


}
