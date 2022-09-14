package com.primeiraapi.controller;

import java.util.List;

import com.primeiraapi.model.Produto;

import com.primeiraapi.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Produto>findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(produtoService.findByIdOrThrowException(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {

        return ResponseEntity.ok(produtoService.save(produto));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Produto>> findAll() {

        return ResponseEntity.ok(produtoService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        this.produtoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {

        return ResponseEntity.ok(produtoService.update(produto));
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<List<Produto>>findByNome(@PathVariable("nome") String nome) {

        return ResponseEntity.ok(produtoService.findByNome(nome));
    }


}
