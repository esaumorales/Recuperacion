package com.example.demo.service;
import com.example.demo.entity.SucursalEntity;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SucursalService {
	SucursalEntity create (SucursalEntity s);
	SucursalEntity update (SucursalEntity s);
	void delete (Long id);
	SucursalEntity read (Long id);
	List<SucursalEntity> readAll();
}
