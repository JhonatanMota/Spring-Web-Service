package com.udemy.cursospring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.udemy.cursospring.abstractes.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends AbstractEntity {

    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    @JsonManagedReference
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
