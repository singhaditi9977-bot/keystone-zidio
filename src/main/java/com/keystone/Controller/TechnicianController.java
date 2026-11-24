package com.keystone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keystone.Entity.Technician;
import com.keystone.Service.TechnicianService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/technician")
@RequiredArgsConstructor
public class TechnicianController {

	@Autowired
	private TechnicianService technicianService;
	
	@PostMapping
	public ResponseEntity<Technician>createTechnician(@RequestBody Technician tecnicians){
		return ResponseEntity.ok(technicianService.createTechnician(tecnicians));
		
	}	
	
	@GetMapping("/getTechnician/{id}")
	public ResponseEntity<Technician> getTechnician(@PathVariable Long id) {
	    return ResponseEntity.ok(technicianService.getTechnician(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Technician>>getAllTechnician(){
		return ResponseEntity.ok(technicianService.getAllTechnician());
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Technician>update(@PathVariable Long id,@RequestBody Technician technician){
		return ResponseEntity.ok(technicianService.updateTechnician(id, technician));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable Long id){
		 
		return ResponseEntity.ok("Technician deleted successfully");
	}
	}

