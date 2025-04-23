package com.example.ATV_usuario.controller;

import com.example.ATV_usuario.dto.UsuarioDto;
import com.example.ATV_usuario.entity.Usuario;
import com.example.ATV_usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf){
        if (nome != null && !nome.isEmpty()){
            return usuarioService.getByNome(nome);
        } else if (cpf != null && !cpf.isEmpty()) {
            return usuarioService.getByCpf(cpf);
        } else {
            return usuarioService.getAll();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id){
        Optional<UsuarioDto> usuarioDtoOptional = usuarioService.getById(id);
        if (usuarioDtoOptional.isPresent()){
            return ResponseEntity.ok(usuarioDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioDtoSave = usuarioService.createUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDtoSave);
    }

    //atualizar dados do usuário menos username e senha
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        Optional<UsuarioDto> usuarioDtoOptional = usuarioService.updateUsuario(id, usuarioDto);
        if (usuarioDtoOptional.isPresent()){
            return ResponseEntity.ok(usuarioDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //atualizar senha do usuario
    @PutMapping("/{id}/senha")
    public ResponseEntity<UsuarioDto> updateSenha(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        Optional<UsuarioDto> usuarioDtoOptional = usuarioService.updateSenhaUsuario(id, usuarioDto);
        if (usuarioDtoOptional.isPresent()){
            return ResponseEntity.ok(usuarioDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (usuarioService.deleteUsuario(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
