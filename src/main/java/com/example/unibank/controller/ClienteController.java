package com.example.unibank.controller;


import com.example.unibank.dtos.ClienteDTO;
import com.example.unibank.entidades.Cliente;
import com.example.unibank.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//O controller será responsável por chamar o Service para que ele interaja com o banco de dados.
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        cliente = service.criarCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<ClienteDTO> listaDeClientes = service.todosClientes();
        return ResponseEntity.ok().body(listaDeClientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> acharId(@PathVariable Long id){
        ClienteDTO cliente = service.acharId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
        service.atualizarCliente(cliente, id);
        return ResponseEntity.noContent().build();

    }

}
