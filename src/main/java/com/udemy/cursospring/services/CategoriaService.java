package com.udemy.cursospring.services;

import com.udemy.cursospring.models.Categoria;
import com.udemy.cursospring.repositories.CategoriaRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    //Autowired é usado para que o spring instancie "automaticamente" a injeção de dependência
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id.longValue());
        return categoria.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado. Id: "+id + ", Tipo: "+Categoria.class.getName()));
    }


}
