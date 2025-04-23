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

    //buscar usuario pelo nome
    public List<Usuario> getByNome(String nome){
        return usuarioRepository.findAllByNome(nome);
    }


    //buscar usuario pelo cpf
    public List<Usuario> getByCpf(String cpf){
        return usuarioRepository.findAllByCpf(cpf);
    }

    //cadastro do usuario
    public UsuarioDto createUsuario(UsuarioDto usuarioDto){
        Usuario usuario = usuarioDto.toUsuario();
        usuario = usuarioRepository.save(usuario);
        return usuarioDto.fromUsuario(usuario);
    }

    //atualizar dados do usuario, menos username e senha
    public Optional<UsuarioDto> updateUsuario(Long id, UsuarioDto usuarioDto){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDto.getNome());
            usuario.setSobrenome(usuarioDto.getSobrenome());
            usuario.setCpf(usuarioDto.getCpf());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setDataDeNascimento(usuarioDto.getDataDeNascimento());

            usuario = usuarioRepository.save(usuario);
            return Optional.of(usuarioDto.fromUsuario(usuario));
        } else {
            return Optional.empty();
        }
    }

    //deletar um usuario
    public boolean deleteUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //atualizar senha do usuario
    public Optional<UsuarioDto> updateSenhaUsuario(Long id, UsuarioDto usuarioDto){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setSenha(usuarioDto.getSenha());
            usuario = usuarioRepository.save(usuario);
            return Optional.of(usuarioDto.fromUsuario(usuario));
        } else {
            return Optional.empty();
        }
    }

}
