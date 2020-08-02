package io.github.rossirui.plataforma.domain.repositories;

import io.github.rossirui.plataforma.domain.entities.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer> {
}
