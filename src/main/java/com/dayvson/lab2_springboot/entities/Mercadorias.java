package com.dayvson.lab2_springboot.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mercadorias", schema = "public")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mercadorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "descricao")
    private String descricao;
}