package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_VUELO;

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

import com.example.demo.entity.VueloEntity;
import com.example.demo.service.VueloService;
@RestController
@RequestMapping(API_VUELO)
public class VueloController {
	
	@Autowired
	private VueloService vueloService;

	@GetMapping("/listar")
	public List<VueloEntity> listar() {
		return vueloService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<VueloEntity> listar2(@PathVariable("id") long id) {
		VueloEntity v = vueloService.read(id);
		if (v!=null) {
			return new ResponseEntity<>(v, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<VueloEntity> createTutorial(@Valid @RequestBody VueloEntity vuel) {
	    try {
	    	VueloEntity v = vueloService.create(vuel);

	      return new ResponseEntity<>(v, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<VueloEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody VueloEntity v) {
		VueloEntity vuelos = vueloService.read(id);

	    if (vuelos!=null) {
	    	vuelos.setId(v.getId());
	    	vuelos.setFecha_salida(v.getFecha_salida());
	    	vuelos.setHora_salida(v.getHora_salida());
	    	vuelos.setFecha_llegada(v.getFecha_llegada());
	    	vuelos.setHora_llegada(v.getHora_llegada());
	    	vuelos.setOrigen(v.getOrigen());
	    	vuelos.setDestino(v.getDestino());
	    	vuelos.setNumero_plazas_totales(v.getNumero_plazas_totales());

	    	return new ResponseEntity<>(vueloService.create(vuelos), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	vueloService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}