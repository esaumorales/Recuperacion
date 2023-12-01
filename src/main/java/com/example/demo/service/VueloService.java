package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VueloEntity;
@Service
public interface VueloService {
	VueloEntity create (VueloEntity v);
	VueloEntity update (VueloEntity v);
	void delete (Long id);
	VueloEntity read (Long id);
	List<VueloEntity> readAll();
}
