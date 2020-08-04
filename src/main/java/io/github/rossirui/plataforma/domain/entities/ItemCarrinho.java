package io.github.rossirui.plataforma.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemCarrinho implements Serializable {
    private static final long serialVeresionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemCarrinhoPK id = new ItemCarrinhoPK();

    private int quantidade;
    private double desconto;
    private double valor;


    @JsonIgnore
    public Carrinho getCarrinho() {
        return id.getCarrinho();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

}
