package com.dayvson.lab2_springboot.entities;

import javax.persistence.*;


@Entity
@Table(name="Venda_Mercadoria",schema="public")

public class Venda_mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda_mercadoria;
    
    @ManyToOne
    @JoinColumn(name="numeroVenda")
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name="codigo")
    private Mercadorias mercadoria;

    public Venda_mercadoria(){}


    public Long getId_venda_mercadoria() {
        return this.id_venda_mercadoria;
    }

    public void setId_venda_mercadoria(Long id_venda_mercadoria) {
        this.id_venda_mercadoria = id_venda_mercadoria;
    }

    public Vendas getVenda() {
        return this.venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Mercadorias getMercadoria() {
        return this.mercadoria;
    }

    public void setMercadoria(Mercadorias mercadoria) {
        this.mercadoria = mercadoria;
    }
}