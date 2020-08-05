package io.github.rossirui.plataforma.domain.services;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import io.github.rossirui.plataforma.domain.entities.ItemCarrinho;
import io.github.rossirui.plataforma.domain.repositories.CarrinhoRepository;
import io.github.rossirui.plataforma.domain.repositories.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public ItemCarrinho buscarPorId(Integer id) {
        return itemCarrinhoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ItemCarrinho> buscar() {
        return itemCarrinhoRepository.findAll();
    }

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public void deletarPorId(Integer id) {
        itemCarrinhoRepository
                .findById(id)
                .map(itemCarrinho -> {
                    itemCarrinhoRepository.delete(itemCarrinho);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void atualizar(ItemCarrinho itemCarrinhoAtualizado, Integer id) {
        ItemCarrinho itemCarrinho = buscarPorId(id);
        double valorProduto = itemCarrinho.getProduto().getValor();

        int quantidade = itemCarrinhoAtualizado.getQuantidade();

        itemCarrinho.setQuantidade(quantidade);

        itemCarrinho.setValor(quantidade * valorProduto);

        if(quantidade >= 10) {
            itemCarrinho.setDesconto(0.1 * itemCarrinho.getValor());
        }

        itemCarrinhoRepository.save(itemCarrinho);
    }
}
