package io.github.rossirui.plataforma.domain.repositories;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
}
