package io.github.rossirui.plataforma.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private double deconto;

    @Column
    private double valor;

}
