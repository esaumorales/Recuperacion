package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_CLIENTE;

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

import com.example.demo.entity.ClienteEntity;
import com.example.demo.service.ClienteService;
@RestController
@RequestMapping(API_CLIENTE)
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/listar")
	public List<ClienteEntity> listar() {
		return clienteService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> listar2(@PathVariable("id") long id) {
		ClienteEntity c = clienteService.read(id);
		if (c!=null) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<ClienteEntity> createTutorial(@Valid @RequestBody ClienteEntity cli) {
	    try {
	    	ClienteEntity c = clienteService.create(cli);

	      return new ResponseEntity<>(c, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<ClienteEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody ClienteEntity c) {
		ClienteEntity cliente = clienteService.read(id);

	    if (cliente!=null) {
	    	cliente.setId(c.getId());
	    	cliente.setDni(c.getDni());
	    	cliente.setNombres(c.getNombres());
	    	cliente.setApellidos(c.getApellidos());
	    	cliente.setTelefono(c.getTelefono());
	    	cliente.setEmail(c.getEmail());

	    	return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	clienteService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}