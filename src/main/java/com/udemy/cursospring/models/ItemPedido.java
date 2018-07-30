package com.udemy.cursospring.models;

import com.udemy.cursospring.abstractes.AbstractEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class ItemPedido implements Serializable {

    @EmbeddedId
    private ItemPedidoPK id;
    private BigDecimal desconto;
    private Integer quantidade;
    private BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(BigDecimal desconto, Integer quantidade, BigDecimal preco, Pedido pedido, Produto produto) {
        id = new ItemPedidoPK();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

}
