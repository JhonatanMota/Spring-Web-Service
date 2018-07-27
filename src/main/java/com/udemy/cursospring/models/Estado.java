package com.udemy.cursospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.udemy.cursospring.abstractes.AbstractEntity;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado extends AbstractEntity {

    private String nome;

    @OneToMany(mappedBy = "estado")
    @JsonBackReference
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
