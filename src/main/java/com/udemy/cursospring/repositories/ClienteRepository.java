package com.udemy.cursospring.repositories;

import com.udemy.cursospring.models.Categoria;
import com.udemy.cursospring.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
