package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.dto.ProdutoDTO;
import io.github.rossirui.plataforma.domain.entities.Produto;
import io.github.rossirui.plataforma.domain.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plataforma/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody @Valid Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<ProdutoDTO> buscar() {
        List<Produto> lista = produtoService.buscar();
        List<ProdutoDTO> listaDTO = lista.stream()
                .map(produto -> new ProdutoDTO(produto))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable Integer id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        produtoService.atualizar(produto, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
    }
}
