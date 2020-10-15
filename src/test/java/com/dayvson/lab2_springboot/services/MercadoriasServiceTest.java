package com.dayvson.lab2_springboot.services;

import java.time.LocalDate;

import com.dayvson.lab2_springboot.entities.Mercadorias;
import com.dayvson.lab2_springboot.entities.Venda_mercadoria;
import com.dayvson.lab2_springboot.entities.Vendas;
import com.dayvson.lab2_springboot.repository.MercadoriasRepository;
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
@ActiveProfiles("teste")
public class MercadoriasServiceTest {
  @Autowired
  MercadoriasService service;

  @Autowired
  MercadoriasRepository repository;

  @Autowired
  VendasService vendasServ;

  @Autowired
  VendasRepository vendasRep;

  @Autowired
  Venda_mercadoriaService venda_mercService;

  @Test
  public void testaVenderMercadoria() {

    LocalDate date = LocalDate.now();

    Mercadorias mercadoria = Mercadorias.builder().descricao("Sabao em po").build();
    Mercadorias mercadoriaSalva = repository.save(mercadoria);

    Assertions.assertNotNull(mercadoriaSalva);
    Assertions.assertEquals(mercadoria.getCodigo(), mercadoriaSalva.getCodigo());
    Assertions.assertEquals(mercadoria.getDescricao(), mercadoriaSalva.getDescricao());

    Vendas newVenda = Vendas.builder().data_venda(date).build();
    Vendas newVendaSalva = vendasRep.save(newVenda);

    Assertions.assertNotNull(newVendaSalva);
    Assertions.assertEquals(newVenda.getNumeroVenda(), newVendaSalva.getNumeroVenda());
    Assertions.assertEquals(newVenda.getData_venda(), newVendaSalva.getData_venda());

    Venda_mercadoria newVendaMerc = Venda_mercadoria.builder().venda(newVenda).mercadoria(mercadoriaSalva).build();
    Venda_mercadoria vendaMercSalva = venda_mercService.salvar(newVendaMerc);

    Assertions.assertNotNull(vendaMercSalva);
    Assertions.assertEquals(newVendaMerc.getId_venda_mercadoria(), vendaMercSalva.getId_venda_mercadoria());
    Assertions.assertEquals(newVendaMerc.getVenda(), vendaMercSalva.getVenda());
    Assertions.assertEquals(newVendaMerc.getMercadoria(), vendaMercSalva.getMercadoria());

    try {

      service.venderMercadoria(mercadoriaSalva, newVendaSalva, vendaMercSalva);

    } catch (Exception e) {

      System.out.println(e);
    }
  }
}
