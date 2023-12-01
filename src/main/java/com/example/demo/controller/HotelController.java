package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_HOTEL;

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

import com.example.demo.entity.HotelEntity;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping(API_HOTEL)
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@GetMapping("/listar")
	public List<HotelEntity> listar() {
		return hotelService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<HotelEntity> listar2(@PathVariable("id") long id) {
		HotelEntity h = hotelService.read(id);
		if (h!=null) {
			return new ResponseEntity<>(h, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<HotelEntity> createTutorial(@Valid @RequestBody HotelEntity hote) {
	    try {
	    	HotelEntity h = hotelService.create(hote);

	      return new ResponseEntity<>(h, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<HotelEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody HotelEntity h) {
		HotelEntity hotel = hotelService.read(id);

	    if (hotel!=null) {
	    	hotel.setId(h.getId());
	    	hotel.setNombre(h.getNombre());
	    	hotel.setDireccion(h.getDireccion());
	    	hotel.setLocalidad(h.getLocalidad());
	    	hotel.setProvincia(h.getProvincia());
	    	hotel.setTelefono(h.getTelefono());
	    	hotel.setNumero_estrellas(h.getNumero_estrellas());


	    	return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	hotelService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}