package io.github.rossirui.plataforma.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    @NotEmpty
    private String nome;

    @Column(nullable = false, length = 150)
    @NotEmpty
    private String descricao;

    @Column(nullable = false)
    @NotNull
    private double valor;

    private ItemCarrinho itemCarrinho;

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemCarrinho> itensCarrinho = new HashSet<>();

    @JsonIgnore
    public List<Carrinho> getCarrinhos() {
        List<Carrinho> lista = new ArrayList<>();
        for(ItemCarrinho ic : itensCarrinho) {
            lista.add(ic.getCarrinho());
        }
        return lista;
    }
}
