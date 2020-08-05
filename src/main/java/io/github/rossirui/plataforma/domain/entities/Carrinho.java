package io.github.rossirui.plataforma.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Campo obrigatório")
    private double deconto;

    @Column
    @NotNull(message = "Campo obrigatório")
    private double valor;

    @Column(updatable = false)
    @NotNull(message = "Campo obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @OneToMany
    private List<Cupom> cupons = new ArrayList<>();

    @OneToMany(mappedBy = "id.carrinho")
    private Set<ItemCarrinho> itensCarrinho = new HashSet<>();

    @PrePersist
    public void prePersist() {
        setData(LocalDate.now());
    }

}
