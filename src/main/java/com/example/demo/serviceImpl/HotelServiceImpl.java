package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
@Component
@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	public HotelRepository hotelRepository;
	
	@Override
	public HotelEntity create(HotelEntity h) {
		// TODO Auto-generated method stub
		return hotelRepository.save(h);
	}

	@Override
	public HotelEntity update(HotelEntity h) {
		// TODO Auto-generated method stub
		return hotelRepository.save(h);
	}

	@Override
	public void delete(Long id) {
		hotelRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelEntity read(Long id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).get();
	}

	@Override
	public List<HotelEntity> readAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

}
