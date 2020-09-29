package com.dayvson.lab2_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayvson.lab2_springboot.entities.Mercadorias;

public interface MercadoriasRepository extends JpaRepository <Mercadorias,Long> {

}
