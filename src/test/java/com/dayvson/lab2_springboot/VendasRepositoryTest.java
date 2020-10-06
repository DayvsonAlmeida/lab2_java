package com.dayvson.lab2_springboot;

import java.time.LocalDate;
import com.dayvson.lab2_springboot.entities.Vendas;
import com.dayvson.lab2_springboot.repository.VendasRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("Teste")
public class VendasRepositoryTest {
  @Autowired
  VendasRepository repository;
  LocalDate localdate = LocalDate.now();

  @Test
  public void verifySavedSell() {
    int value = 1;
    Long longValue = Long.valueOf(value);
    LocalDate date = LocalDate.now();
    Vendas sell = Vendas.builder().numeroVenda(longValue).data_venda(date).build();

    Vendas persisted = repository.save(sell);

    Assertions.assertNotNull(persisted);
    Assertions.assertEquals(sell.getNumeroVenda(), persisted.getNumeroVenda());
    Assertions.assertEquals(sell.getData_venda(), persisted.getData_venda());
  }

  @Test
  public void verificaSeSalvaVendaSemData() {
    int value = 1;
    Long longValue = Long.valueOf(value);
    Vendas sell = Vendas.builder().numeroVenda(longValue).build();

    Vendas persisted = repository.save(sell);

    Assertions.assertNotNull(persisted);
    Assertions.assertEquals(sell.getNumeroVenda(), persisted.getNumeroVenda());
    Assertions.assertEquals(sell.getData_venda(), persisted.getData_venda());
  }
}