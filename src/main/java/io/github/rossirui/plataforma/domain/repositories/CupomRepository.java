package io.github.rossirui.plataforma.domain.repositories;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, Integer> {
}
