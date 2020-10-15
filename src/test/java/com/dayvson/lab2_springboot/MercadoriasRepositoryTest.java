package com.dayvson.lab2_springboot;

import com.dayvson.lab2_springboot.entities.Mercadorias;
import com.dayvson.lab2_springboot.repository.MercadoriasRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("Test")
public class MercadoriasRepositoryTest {
  @Autowired
  MercadoriasRepository repository;

  @Test
  public void verificaSalvaMercadoria() {
    int value = 1;
    Long longValue = Long.valueOf(value);
    Mercadorias item = Mercadorias.builder().codigo(longValue).descricao("Produto Maneiro").build();

    Mercadorias persisted = repository.save(item);

    Assertions.assertNotNull(persisted);
    Assertions.assertEquals(item.getCodigo(), persisted.getCodigo());
    Assertions.assertEquals(item.getDescricao(), persisted.getDescricao());
  }
}