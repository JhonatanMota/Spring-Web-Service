package com.udemy.cursospring.services;

import com.udemy.cursospring.models.Categoria;
import com.udemy.cursospring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    //Autowired é usado para que o spring instancie "automaticamente" a injeção de dependência
    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElse(null);
    }
}
