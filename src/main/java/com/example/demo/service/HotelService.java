package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelEntity;
@Component
@Service
public interface HotelService {
	HotelEntity create (HotelEntity h);
	HotelEntity update (HotelEntity h);
	void delete (Long id);
	HotelEntity read (Long id);
	List<HotelEntity> readAll();
}
