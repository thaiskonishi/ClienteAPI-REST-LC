package com.example.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
// Por ser uma interface e não classe não preciso ter nenhuma anotação spring q
// ele encontra automaticamente.