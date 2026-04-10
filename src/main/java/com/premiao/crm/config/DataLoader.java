package com.premiao.crm.config;

import com.premiao.crm.model.Usuario;
import com.premiao.crm.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner seedAdminUsuario(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!usuarioRepository.existsByEmail("admin@premiapao.com")) {
                Usuario admin = new Usuario();
                admin.setNome("Admin PremiaPão");
                admin.setEmail("admin@premiapao.com");
                admin.setSenhaHash(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                admin.setAtivo(true);
                admin.setCriadoEm(LocalDateTime.now());
                usuarioRepository.save(admin);
            }
        };
    }
}
