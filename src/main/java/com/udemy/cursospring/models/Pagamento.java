package com.udemy.cursospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.udemy.cursospring.abstractes.AbstractEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends AbstractEntity {

    private Integer estadoPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    @JsonBackReference
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer estadoPagamento, Pedido pedido) {
        this.estadoPagamento = estadoPagamento;
        this.pedido = pedido;
    }

    public Integer getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(Integer estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
