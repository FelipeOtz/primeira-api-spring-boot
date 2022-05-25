package com.primeiraapi.service;

import java.util.List;
import java.util.Optional;

import com.primeiraapi.model.Produto;
import com.primeiraapi.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findByIdOrThrowException(Long id) {

        return this.produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto com ID: "+id+", não encontrado!"));

    }

    public Produto save(Produto produto) { return this.produtoRepository.save(produto); }

    public void deleteById(Long id) {

        this.findByIdOrThrowException(id);

        this.produtoRepository.deleteById(id);
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }
}
