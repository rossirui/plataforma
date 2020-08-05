package io.github.rossirui.plataforma.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Campo obrigatório")
    private int quantidade;

    private double desconto;

    @NotNull(message = "Campo obrigatório")
    private double valor;


    @JsonIgnore
    public Carrinho getCarrinho() {
        return id.getCarrinho();
    }

    public void setCarrinho(Carrinho carrinho) {
        this.id.setCarrinho(carrinho);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        this.id.setProduto(produto);
    }

}
