package com.example.unibank.entidades;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String profissao;
    private Instant dataNascimento;
    private String email;
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Conta conta;

    @OneToOne(mappedBy = "cp", cascade = CascadeType.ALL)
    private ContaPoupanca contaPoupança;
    @Autowired
    private Banco banco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String profissao, Instant dataNascimento, String email, Banco banco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.banco = banco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaPoupanca getContaPoupança() {
        return contaPoupança;
    }

    public void setContaPoupança(ContaPoupanca contaPoupança) {
        this.contaPoupança = contaPoupança;
    }

    @Override
    public boolean equals(Object o) {//equals and hashcode faz comparações de entidades baseadas em algum atributos escolhido
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
