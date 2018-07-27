package com.udemy.cursospring;

import com.udemy.cursospring.models.Categoria;
import com.udemy.cursospring.models.Cidade;
import com.udemy.cursospring.models.Estado;
import com.udemy.cursospring.models.Produto;
import com.udemy.cursospring.repositories.CategoriaRepository;
import com.udemy.cursospring.repositories.CidadeRepository;
import com.udemy.cursospring.repositories.EstadoRepository;
import com.udemy.cursospring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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
    }
}
