package com.udemy.cursospring.models;

import com.udemy.cursospring.models.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;


    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estadoPagamento.getCod(), pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
