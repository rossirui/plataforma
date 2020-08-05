package io.github.rossirui.plataforma.domain.controllers;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import io.github.rossirui.plataforma.domain.entities.ItemCarrinho;
import io.github.rossirui.plataforma.domain.entities.Produto;
import io.github.rossirui.plataforma.domain.services.CarrinhoService;
import io.github.rossirui.plataforma.domain.services.ItemCarrinhoService;
import io.github.rossirui.plataforma.domain.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma/itens-carrinhos")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/carrinho/{carrinho_id}/produto/{produto_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemCarrinho salvar(@RequestBody ItemCarrinho itemCarrinho,
                               @PathVariable Integer carrinho_id,
                               @PathVariable Integer produto_id) {

        Carrinho carrinho = carrinhoService.buscarPorId(carrinho_id);
        itemCarrinho.setCarrinho(carrinho);

        Produto produto = produtoService.buscarPorId(produto_id);
        itemCarrinho.setProduto(produto);

        itemCarrinho.setQuantidade(1);
        itemCarrinho.setValor(itemCarrinho.getQuantidade() * produto.getValor());

        return itemCarrinhoService.salvar(itemCarrinho);
    }

    @PutMapping("/carrinho/{carrinho_id}/produto/{produto_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody ItemCarrinho itemCarrinho, @PathVariable Integer id) {
        itemCarrinhoService.atualizar(itemCarrinho, id);
    }

    @GetMapping
    public List<ItemCarrinho> buscar() {
        return itemCarrinhoService.buscar();
    }

    @GetMapping("{id}")
    public ItemCarrinho buscarPorId(@PathVariable Integer id) {
        return itemCarrinhoService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Integer id) {
        itemCarrinhoService.deletarPorId(id);
    }
}
