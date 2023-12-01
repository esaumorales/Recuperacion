package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClienteEntity;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
@Component
@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	public ClienteRepository clienteRepository;

	@Override
	public ClienteEntity create(ClienteEntity c) {
		// TODO Auto-generated method stub
		return clienteRepository.save(c);
	}
	

	@Override
	public ClienteEntity update(ClienteEntity c) {
		// TODO Auto-generated method stub
		return clienteRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteEntity read(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).get();
	}

	@Override
	public List<ClienteEntity> readAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}
}
