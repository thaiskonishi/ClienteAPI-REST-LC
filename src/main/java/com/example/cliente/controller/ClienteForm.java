package com.example.cliente.controller;

import com.example.cliente.model.Cliente;

public class ClienteForm {

    private String vatnumber;
    private String nome;
    private String email;
    private int idade;

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cliente converter() {
        return new Cliente(vatnumber, nome, email, idade);
    }
}
