package io.github.rossirui.plataforma.domain.services;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    public Cupom salvar(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    public Cupom buscarPorId(Integer id) {
        return cupomRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Cupom> buscar() {
        return cupomRepository.findAll();
    }

}
