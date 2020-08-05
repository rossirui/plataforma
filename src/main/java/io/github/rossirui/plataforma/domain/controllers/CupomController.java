package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.services.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma/cupons")
public class CupomController {

    @Autowired
    private CupomService cupomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cupom salvar(@RequestBody Cupom cupom) {
        return cupomService.salvar(cupom);
    }

    @GetMapping
    private List<Cupom> buscar() {
        return cupomService.buscar();
    }
}
