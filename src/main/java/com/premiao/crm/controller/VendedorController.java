package com.premiao.crm.controller;

import com.premiao.crm.model.Vendedor;
import com.premiao.crm.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin(origins = "*") // Permite acesso do frontend
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listarTodos() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vendedor> criar(@RequestBody Vendedor vendedor) {
        try {
            Vendedor novo = service.save(vendedor);
            return ResponseEntity.status(201).body(novo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        try {
            Vendedor atualizado = service.update(id, vendedor);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
