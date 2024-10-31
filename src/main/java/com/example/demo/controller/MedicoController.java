package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Medico;
import com.example.demo.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping
	public ResponseEntity<List<Medico>> readAll(){
		try {
			List<Medico> Medicos = medicoService.readAll();
			if(Medicos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Medicos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Medico> crear(@Valid @RequestBody Medico cat){
		try {
			Medico c = medicoService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Medico> getMedicoId(@PathVariable("id") Long id){
		try {
			Medico c = medicoService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    @PreAuthorize("hasRole('ADMIN') ")
	@DeleteMapping("/{id}")
	public ResponseEntity<Medico> delMedico(@PathVariable("id") Long id){
		try {
			medicoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    @PreAuthorize("hasRole('ADMIN') ")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMedico(@PathVariable("id") Long id, @Valid @RequestBody Medico cat){

			Optional<Medico> c = medicoService.read(id);
			if(c.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				
				return new ResponseEntity<>(medicoService.update(cat), HttpStatus.OK);
			}			
	}
}
