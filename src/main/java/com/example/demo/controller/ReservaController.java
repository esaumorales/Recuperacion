package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_RESERVA;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ReservaEntity;
import com.example.demo.service.ReservaService;
@RestController
@RequestMapping(API_RESERVA)
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/listar")
	public List<ReservaEntity> listar() {
		return reservaService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservaEntity> listar2(@PathVariable("id") long id) {
		ReservaEntity v = reservaService.read(id);
		if (v!=null) {
			return new ResponseEntity<>(v, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<ReservaEntity> createTutorial(@Valid @RequestBody ReservaEntity rese) {
	    try {
	    	ReservaEntity r = reservaService.create(rese);

	      return new ResponseEntity<>(r, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<ReservaEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody ReservaEntity r) {
		ReservaEntity reserva = reservaService.read(id);

	    if (reserva!=null) {
	    	reserva.setId(r.getId());
	    	reserva.setClase(r.getClase());



	    	return new ResponseEntity<>(reservaService.create(reserva), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	reservaService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}