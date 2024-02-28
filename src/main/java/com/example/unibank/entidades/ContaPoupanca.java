package com.example.unibank.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "conta_poupanca")
public class ContaPoupanca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer agencia;
    private Integer contaCorrente;
    private Double saldo = 0.0;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Cliente cp;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Long id, Integer agencia, Integer contaCorrente, Double saldo, Cliente cliente) {
        this.id = id;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.saldo = saldo;
        this.cp = cliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCp() {
        return cp;
    }

    public void setCp(Cliente cp) {
        this.cp = cp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void depositar(Double valor){
        if(valor > 0.0){
            saldo += valor + (valor * 10 / 100);
            System.out.println("Depósito efetuado com sucesso, seu saldo atual é de R$ " + String.format("%.2f", saldo));
        } else {
            System.out.println("Você não informou valor a ser depositado.");
        }
    }

    public void sacar(Double valor) throws Exception {
        if(valor > 0.0 && saldo > 0.0){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void transferir(Double valor, Conta contaRemetente) throws Exception {
        if(valor > 0.0 && saldo > 0.0){
            contaRemetente.sacar(valor);
            this.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada", valor);
        } else {
            System.out.println("Transferência negada, saldo insuficiente.");
        }
    }
}

