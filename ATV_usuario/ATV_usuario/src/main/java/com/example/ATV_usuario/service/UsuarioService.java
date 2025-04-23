package com.example.ATV_usuario.service;

import com.example.ATV_usuario.dto.UsuarioDto;
import com.example.ATV_usuario.entity.Usuario;
import com.example.ATV_usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //busca todos os usuarios
    public List<Usuario> getAll(){
         return usuarioRepository.findAll();
    }

    //buscar usuario pelo seu id
    public Optional<UsuarioDto> getById(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            UsuarioDto usuarioDto = new UsuarioDto();
            return Optional.of(usuarioDto.fromUsuario(usuarioOptional.get()));
        } else {
            return Optional.empty();
        }
    }
    //cadastro do usuario
    public UsuarioDto createUsuario(UsuarioDto usuarioDto){
        Usuario usuario = usuarioDto.toUsuario();
        usuario = usuarioRepository.save(usuario);
        return usuarioDto.fromUsuario(usuario);
    }

    //atualizar dados do usuario, menos username e senha
//    public Optional<UsuarioDto> updateUsuario(Long id, UsuarioDto usuarioDto){
//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//        if (usuarioOptional.isPresent()){
//            Usuario usuario = usuarioOptional.get();
//            usuario.set
//        }
//    }

}
