package io.github.rossirui.plataforma.domain.services;

import io.github.rossirui.plataforma.domain.entities.Carrinho;
import io.github.rossirui.plataforma.domain.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho buscarPorId(Integer id) {
        return carrinhoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Carrinho> buscar() {
        return carrinhoRepository.findAll();
    }

    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }
}
