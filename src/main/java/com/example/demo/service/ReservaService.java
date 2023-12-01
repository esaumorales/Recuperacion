package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ReservaEntity;
@Component
@Service
public interface ReservaService {
	ReservaEntity create (ReservaEntity r);
	ReservaEntity update (ReservaEntity r);
	void delete (Long id);
	ReservaEntity read (Long id);
	List<ReservaEntity> readAll();
}
