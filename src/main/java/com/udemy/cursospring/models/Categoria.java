package com.udemy.cursospring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.udemy.cursospring.abstractes.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria extends AbstractEntity {

    @NotBlank(message = "O nome da categoria é obrigatório.")
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    @JsonManagedReference
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(@NotBlank(message = "O nome da categoria é obrigatório.") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
