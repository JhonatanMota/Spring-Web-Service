package com.udemy.cursospring.repositories;

import com.udemy.cursospring.models.Cidade;
import com.udemy.cursospring.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
