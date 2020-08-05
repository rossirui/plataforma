package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import io.github.rossirui.plataforma.domain.entities.Cupom;
import io.github.rossirui.plataforma.domain.services.CarrinhoService;
import io.github.rossirui.plataforma.domain.services.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private CupomService cupomService;

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

    @PutMapping("{carrinho_id}/cupom/{cupom_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inserirCupom(@PathVariable Integer carrinho_id, @PathVariable Integer cupom_id) {
        Carrinho carrinho = carrinhoService.buscarPorId(carrinho_id);
        List<Cupom> listaCupons = carrinho.getCupons();
        listaCupons.add(cupomService.buscarPorId(cupom_id));
        carrinho.setCupons(listaCupons);

        carrinhoService.atualizar(carrinho, carrinho_id);
    }
}
