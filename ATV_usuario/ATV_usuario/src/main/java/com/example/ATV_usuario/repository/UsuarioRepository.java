package com.example.ATV_usuario.repository;

import com.example.ATV_usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNome(String nome);
    List<Usuario> findAllByCpf(String cpf);
}
