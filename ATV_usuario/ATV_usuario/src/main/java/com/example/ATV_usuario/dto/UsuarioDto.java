package com.example.ATV_usuario.dto;

import com.example.ATV_usuario.entity.Usuario;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String username;
    @Column(unique = true)
    private String senha;
    private LocalDate dataDeNascimento;

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.email,
                this.username,
                this.senha,
                this.dataDeNascimento
        );
    }

    public UsuarioDto fromUsuario(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataDeNascimento()
        );
    }

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String sobrenome, String cpf, String email, String username, String senha, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
