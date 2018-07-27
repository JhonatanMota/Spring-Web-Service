package com.udemy.cursospring.models;

import com.udemy.cursospring.abstractes.AbstractEntity;
import com.udemy.cursospring.models.enums.TipoCliente;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends AbstractEntity {

    private String nome;
    private String email;
    private String docIdentificacao;
    private Integer tipo;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, String docIdentificacao, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.docIdentificacao = docIdentificacao;
        this.tipo = tipo.getCod();
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

    public String getDocIdentificacao() {
        return docIdentificacao;
    }

    public void setDocIdentificacao(String docIdentificacao) {
        this.docIdentificacao = docIdentificacao;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }
}
