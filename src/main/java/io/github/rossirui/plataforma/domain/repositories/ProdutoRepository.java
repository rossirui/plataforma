package io.github.rossirui.plataforma.domain.repositories;

import io.github.rossirui.plataforma.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
