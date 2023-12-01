package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SucursalEntity;
import com.example.demo.repository.SucursalRepository;
import com.example.demo.service.SucursalService;
@Component
@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	public SucursalRepository sucursalRepository;

	@Override
	public SucursalEntity create(SucursalEntity s) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(s);
	}

	@Override
	public SucursalEntity update(SucursalEntity s) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(s);
	}

	@Override
	public void delete(Long id) {
		sucursalRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public SucursalEntity read(Long id) {
		// TODO Auto-generated method stub
		return sucursalRepository.findById(id).get();
	}

	@Override
	public List<SucursalEntity> readAll() {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll();
	}

}
