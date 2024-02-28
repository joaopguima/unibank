package com.example.unibank.configuration;

import com.example.unibank.entidades.*;
import com.example.unibank.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class ClienteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository repositoryCliente;

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente(null, "Leo Gobetti", "123456781", "Desenvolvedor Back End", Instant.parse("1998-01-01T01:00:00Z"), "leogb@example.com", Banco.ITAU);
        Cliente cliente2 = new Cliente(null, "João Pedro", "123456789", "Desenvolvedor Back End", Instant.parse("1999-01-01T01:00:00Z"), "joaop@example.com", Banco.SANTANDER);

        repositoryCliente.saveAll(Arrays.asList(cliente1, cliente2));

        Conta conta1 = new Conta(null, 0111, 22334, 0.0, cliente1);
        Conta conta2 = new Conta(null, 0112, 22335, 0.0, cliente2);

        cliente1.setConta(conta1);
        cliente2.setConta(conta2);

        conta1.depositar(200.0);
        conta2.depositar(200.00);
        conta1.sacar(50.00);

        conta1.transferir(25.50, conta2);


        repositoryCliente.saveAll(Arrays.asList(cliente1, cliente2));

        ContaPoupanca cp1 = new ContaPoupanca(null, 0113, 22336, 0.0, cliente1);
        cp1.depositar(200.0);

        cliente1.setContaPoupança(cp1);

        cp1.transferir(100.0, conta1);

        repositoryCliente.saveAll(Arrays.asList(cliente1));


    }

}
