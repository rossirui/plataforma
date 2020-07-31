package io.github.rossirui.plataforma.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valor;

}
