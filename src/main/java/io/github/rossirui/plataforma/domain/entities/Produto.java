package io.github.rossirui.plataforma.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private double valor;

}
