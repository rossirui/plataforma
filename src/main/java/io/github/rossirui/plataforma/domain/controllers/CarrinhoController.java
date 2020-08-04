package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import io.github.rossirui.plataforma.domain.services.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma/carrinhos")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrinho salvar(@RequestBody Carrinho carrinho) {
        return carrinhoService.salvar(carrinho);
    }

    @GetMapping
    public List<Carrinho> buscar() {
        return carrinhoService.buscar();
    }


    @GetMapping("{id}")
    public Carrinho buscarPorId(@PathVariable Integer id) {
        return carrinhoService.buscarPorId(id);
    }
}
