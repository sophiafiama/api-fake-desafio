package com.sophiafiama.apifilmesdesafio.model;

import lombok.Getter;

import javax.persistence.Table;

@Getter
@Table
public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String nome;

    private Role(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return getNome();
    }


}