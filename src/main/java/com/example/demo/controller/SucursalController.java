package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_SUCURSAL;

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

import com.example.demo.entity.SucursalEntity;
import com.example.demo.service.SucursalService;
@RestController
@RequestMapping(API_SUCURSAL)
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;

	@GetMapping("/listar")
	public List<SucursalEntity> listar() {
		return sucursalService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SucursalEntity> listar2(@PathVariable("id") long id) {
		SucursalEntity s = sucursalService.read(id);
		if (s!=null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<SucursalEntity> createTutorial(@Valid @RequestBody SucursalEntity suc) {
	    try {
	    	SucursalEntity s = sucursalService.create(suc);

	      return new ResponseEntity<>(s, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<SucursalEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody SucursalEntity s) {
		SucursalEntity sucursal = sucursalService.read(id);

	    if (sucursal!=null) {
	    	sucursal.setId(s.getId());
	    	sucursal.setDireccion(s.getDireccion());
	    	sucursal.setLocalidad(s.getLocalidad());
	    	sucursal.setProvincia(s.getProvincia());
	    	sucursal.setTelefono(s.getTelefono());


	    	return new ResponseEntity<>(sucursalService.create(sucursal), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	sucursalService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}