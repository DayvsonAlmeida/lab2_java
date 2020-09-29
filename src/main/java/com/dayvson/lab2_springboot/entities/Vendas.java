package com.dayvson.lab2_springboot.entities;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@Entity
@Table(name="Vendas",schema="public")

public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numeroVenda")
    private Long numeroVenda;

    @Column(name="data_venda")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate data_venda;


    //Construtor
    public Vendas(){}

    //Gets e Sets
    public Long getNumeroVenda() {
        return this.numeroVenda;
    }

    public void setNumeroVenda(Long numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public LocalDate getData_venda() {
        return this.data_venda;
    }

    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }
}