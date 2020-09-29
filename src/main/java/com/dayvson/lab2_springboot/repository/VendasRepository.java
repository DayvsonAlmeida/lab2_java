package com.dayvson.lab2_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayvson.lab2_springboot.entities.Vendas;

public interface VendasRepository extends JpaRepository <Vendas, Long>{
    
}
