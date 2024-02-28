package com.example.unibank.repositories;

import com.example.unibank.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //O repository será responsável por injetar a dependência do JPA para fazer as atualizações CRUD
}
