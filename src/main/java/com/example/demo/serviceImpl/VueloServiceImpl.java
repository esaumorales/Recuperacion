package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VueloEntity;
import com.example.demo.repository.VueloRepository;
import com.example.demo.service.VueloService;
@Component
@Service
public class VueloServiceImpl implements VueloService{

	@Autowired
	public VueloRepository vueloRepository;

	@Override
	public VueloEntity create(VueloEntity v) {
		// TODO Auto-generated method stub
		return vueloRepository.save(v);
	}

	@Override
	public VueloEntity update(VueloEntity v) {
		// TODO Auto-generated method stub
		return vueloRepository.save(v);
	}

	@Override
	public void delete(Long id) {
		vueloRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public VueloEntity read(Long id) {
		// TODO Auto-generated method stub
		return vueloRepository.findById(id).get();
	}

	@Override
	public List<VueloEntity> readAll() {
		// TODO Auto-generated method stub
		return vueloRepository.findAll();
	}
}
