package com.example.unibank.dtos;

import com.example.unibank.entidades.Banco;
import com.example.unibank.entidades.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String profissao;
    private String email;
    private Banco banco;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        profissao = cliente.getProfissao();
        email = cliente.getEmail();
        banco = cliente.getBanco();
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
