package com.premiao.crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Double metaVendas;

    @Column(nullable = false)
    private Double vendasRealizadas;

    // Campo calculado: percentual da meta atingida
    @Transient
    public Double getPercentualMeta() {
        if (metaVendas == null || metaVendas == 0) return 0.0;
        return (vendasRealizadas / metaVendas) * 100;
    }
}
