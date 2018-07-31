package com.udemy.cursospring.services;

import com.udemy.cursospring.models.Pedido;
import com.udemy.cursospring.repositories.PedidoRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    //Autowired é usado para que o spring instancie "automaticamente" a injeção de dependência
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido find(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id.longValue());
        return pedido.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado. Id: "+id + ", Tipo: "+Pedido.class.getName()));
    }


}
