package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plataforma/cupons")
public class CupomController {

    private final CupomRepository cupomRepository;

    @Autowired
    public CupomController(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cupom salvar(@RequestBody Cupom cupom) {
        return cupomRepository.save(cupom);
    }
}
