package io.github.rossirui.plataforma.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int quantidade;

    @Column
    private double desconto;

    @Column
    private double valor;

}
