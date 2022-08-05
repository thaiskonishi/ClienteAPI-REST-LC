package com.example.cliente.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.cliente.controller.dto.ClienteDto;
import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;

@RestController
@RequestMapping("/client")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository; // injeção de dependencias

    @GetMapping({ "/list" })
    public List<ClienteDto> lista() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.converter(clientes);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> alteraDados(@PathVariable Long id, @RequestBody @Validated ClienteForm form) {
        Cliente cliente = form.alterarDados(id, clienteRepository);

        return ResponseEntity.ok(new ClienteDto(cliente));
    }

    // o clientForm é pra pegar no corpo da requisição e não da url
    @PostMapping(" ")
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Validated ClienteForm form,
            UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
