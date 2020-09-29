package com.dayvson.lab2_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayvson.lab2_springboot.entities.Venda_mercadoria;

public interface Venda_MercadoriaRepository extends JpaRepository <Venda_mercadoria, Long> {
    
}
