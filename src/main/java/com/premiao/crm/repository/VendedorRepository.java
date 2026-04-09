package com.premiao.crm.repository;

import com.premiao.crm.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    // Métodos básicos já herdados: save, findAll, findById, deleteById, etc.
    
    // Método personalizado para buscar por email
    boolean existsByEmail(String email);
}
