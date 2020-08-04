package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.services.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plataforma/cupons")
public class CupomController {

    private final CupomService cupomService;

    @Autowired
    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cupom salvar(@RequestBody Cupom cupom) {
        return cupomService.salvar(cupom);
    }
}
