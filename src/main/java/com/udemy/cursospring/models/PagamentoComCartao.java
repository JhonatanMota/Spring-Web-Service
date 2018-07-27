package com.udemy.cursospring.models;

import java.time.LocalDate;

public class PagamentoComCartao extends Pagamento {

    private Integer numeroParcela;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer estadoPagamento, Pedido pedido, Integer numeroParcela) {
        super(estadoPagamento, pedido);
        this.numeroParcela = numeroParcela;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }
}
