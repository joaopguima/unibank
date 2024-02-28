package com.example.unibank.services;

import com.example.unibank.dtos.ClienteDTO;
import com.example.unibank.entidades.Cliente;
import com.example.unibank.repositories.ClienteRepository;
import com.example.unibank.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired//injeção de dependência do repository
    private ClienteRepository repository;

    public Cliente criarCliente(Cliente cliente){

        return repository.save(cliente);
    }

    public List<ClienteDTO> todosClientes(){

        List<Cliente> listaCliente = repository.findAll();
        List<ClienteDTO> listaClienteDTO = listaCliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
        return listaClienteDTO;
    }

    public ClienteDTO acharId(Long id){
        try {
            Cliente cliente = repository.findById(id).get();
            ClienteDTO clienteDto = new ClienteDTO(cliente);
            return clienteDto;
        } catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente atualizarCliente(Cliente novoCliente, Long id){
        try {
            Cliente cliente = repository.getReferenceById(id);
            clienteData(cliente, novoCliente);
            return repository.save(cliente);
        } catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void clienteData(Cliente cliente, Cliente novoCliente){
        cliente.setNome(novoCliente.getNome());
        cliente.setProfissao(novoCliente.getProfissao());
    }

    public void deleteCliente(Long id){
        acharId(id);
        repository.deleteById(id);
    }

}
