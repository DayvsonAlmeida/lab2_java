package com.dayvson.lab2_springboot.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Venda_Mercadoria", schema = "public")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda_mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda_mercadoria;

    @ManyToOne
    @JoinColumn(name = "numeroVenda")
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Mercadorias mercadoria;
}