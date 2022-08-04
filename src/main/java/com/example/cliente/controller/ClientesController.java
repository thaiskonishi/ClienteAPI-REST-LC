package com.example.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.controller.dto.ClienteDto;
import com.example.cliente.modelos.Cliente;
import com.example.cliente.repository.ClienteRepository;

@RestController
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository; // injeção de dependencias

    @GetMapping({ "/clientes" })
    public List<ClienteDto> lista() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.converter(clientes);

    }

}
