package io.github.rossirui.plataforma.domain.services;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    public Cupom salvar(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

}
