package com.udemy.cursospring;

import com.udemy.cursospring.models.*;
import com.udemy.cursospring.models.enums.EstadoPagamento;
import com.udemy.cursospring.models.enums.TipoCliente;
import com.udemy.cursospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto p1 = new Produto("Computador", BigDecimal.valueOf(2000));
        Produto p2 = new Produto("Impressora", BigDecimal.valueOf(800));
        Produto p3 = new Produto("Mouse", BigDecimal.valueOf(80));

        Categoria categoria1 = new Categoria("Informática");
        categoria1.getProdutos().addAll(Arrays.asList(p1, p2, p3));

        Categoria categoria2 = new Categoria("Escritório");
        categoria1.getProdutos().add(p2);

        p1.getCategorias().add(categoria1);
        p3.getCategorias().add(categoria1);
        p2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));


        Estado estado1 = new Estado("Minas Gerais");
        Estado estado2 = new Estado("São Paulo");

        Cidade c1 = new Cidade("Uberlândia", estado1);
        Cidade c2 = new Cidade("São Paulo", estado2);
        Cidade c3 = new Cidade("Campinas", estado2);

        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cliente1 = new Cliente("Maria Silva", "maria@gamil.com", "36536536545",
                TipoCliente.PESSOAFISICA);
        cliente1.getTelefones().addAll(Arrays.asList("27364548", "981387881"));

        Endereco end1 = new Endereco("Rua Flores", "300", "Apto 303", "Jardim", "35487", cliente1, c1);
        Endereco end2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "77001002", cliente1, c2);

        cliente1.getEnderecos().addAll(Arrays.asList(end1, end2));

        clienteRepository.save(cliente1);
        enderecoRepository.saveAll(Arrays.asList(end1, end2));

        Pedido ped1 = new Pedido(LocalDate.of(2017, Month.SEPTEMBER, 30), cliente1, end1);
        Pedido ped2 = new Pedido(LocalDate.of(2017, Month.OCTOBER, 10), cliente1, end2);

        Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, LocalDate.of(2017, Month.OCTOBER, 19), null);
        ped2.setPagamento(pagto2);

        cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(BigDecimal.ZERO, 1, BigDecimal.valueOf(2000), ped1, p1);
        ItemPedido ip2 = new ItemPedido(BigDecimal.ZERO, 2, BigDecimal.valueOf(80), ped1, p3);
        ItemPedido ip3 = new ItemPedido(BigDecimal.valueOf(800), 1, BigDecimal.valueOf(800), ped2, p2);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().add(ip3);

        p1.getItens().add(ip1);
        p1.getItens().add(ip3);
        p1.getItens().add(ip2);

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
