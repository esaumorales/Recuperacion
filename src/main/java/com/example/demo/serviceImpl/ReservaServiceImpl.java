package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ReservaEntity;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.ReservaService;
@Component
@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	public ReservaRepository reservaRepository;

	@Override
	public ReservaEntity create(ReservaEntity r) {
		// TODO Auto-generated method stub
		return reservaRepository.save(r);
	}

	@Override
	public ReservaEntity update(ReservaEntity r) {
		// TODO Auto-generated method stub
		return reservaRepository.save(r);
	}

	@Override
	public void delete(Long id) {
		reservaRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReservaEntity read(Long id) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id).get();
	}

	@Override
	public List<ReservaEntity> readAll() {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}
}
