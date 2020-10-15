package com.dayvson.lab2_springboot.repository;

import java.util.Optional;

import com.dayvson.lab2_springboot.entities.Mercadorias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriasRepository extends JpaRepository<Mercadorias, Long> {
  Optional<Mercadorias> findById(Long id);
}
