package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClienteEntity;
@Component
@Service
public interface ClienteService {
	ClienteEntity create (ClienteEntity c);
	ClienteEntity update (ClienteEntity c);
	void delete (Long id);
	ClienteEntity read (Long id);
	List<ClienteEntity> readAll();
}
