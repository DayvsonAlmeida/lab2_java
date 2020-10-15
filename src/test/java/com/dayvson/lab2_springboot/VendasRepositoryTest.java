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
    LocalDate date = LocalDate.now();
    Vendas venda = Vendas.builder().data_venda(date).build();

    Vendas salvo = repository.save(venda);

    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(venda.getNumeroVenda(), salvo.getNumeroVenda());
    Assertions.assertEquals(venda.getData_venda(), salvo.getData_venda());
  }

  @Test
  public void verifySavedSellWithoutDate() {
    Vendas venda = Vendas.builder().build();

    Vendas salvo = repository.save(venda);

    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(venda.getNumeroVenda(), salvo.getNumeroVenda());
    Assertions.assertEquals(venda.getData_venda(), salvo.getData_venda());
  }
}