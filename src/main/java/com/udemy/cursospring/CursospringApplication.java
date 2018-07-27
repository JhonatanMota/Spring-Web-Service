package com.udemy.cursospring;

import com.udemy.cursospring.models.Categoria;
import com.udemy.cursospring.models.Produto;
import com.udemy.cursospring.repositories.CategoriaRepository;
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
    }
}
