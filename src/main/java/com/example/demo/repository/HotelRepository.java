package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelEntity;


public interface HotelRepository extends JpaRepository<HotelEntity, Long>{

}
