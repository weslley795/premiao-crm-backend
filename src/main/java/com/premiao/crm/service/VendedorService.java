package com.premiao.crm.service;

import com.premiao.crm.model.Vendedor;
import com.premiao.crm.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> findAll() {
        return repository.findAll();
    }

    public Optional<Vendedor> findById(Long id) {
        return repository.findById(id);
    }

    public Vendedor save(Vendedor vendedor) {
        // Validação: email único
        if (repository.existsByEmail(vendedor.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return repository.save(vendedor);
    }

    public Vendedor update(Long id, Vendedor vendedorAtualizado) {
        return repository.findById(id)
            .map(vendedor -> {
                vendedor.setNome(vendedorAtualizado.getNome());
                vendedor.setEmail(vendedorAtualizado.getEmail());
                vendedor.setTelefone(vendedorAtualizado.getTelefone());
                vendedor.setMetaVendas(vendedorAtualizado.getMetaVendas());
                vendedor.setVendasRealizadas(vendedorAtualizado.getVendasRealizadas());
                return repository.save(vendedor);
            })
            .orElseThrow(() -> new RuntimeException("Vendedor não encontrado!"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
