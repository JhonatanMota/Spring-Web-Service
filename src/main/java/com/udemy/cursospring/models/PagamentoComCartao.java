package com.udemy.cursospring.models;

import com.udemy.cursospring.models.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {

    private Integer numeroParcela;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcela) {
        super(estadoPagamento.getCod(), pedido);
        this.numeroParcela = numeroParcela;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }
}
