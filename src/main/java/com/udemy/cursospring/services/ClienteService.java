package com.udemy.cursospring.services;

import com.udemy.cursospring.models.Cliente;
import com.udemy.cursospring.repositories.ClienteRepository;
import com.udemy.cursospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    //Autowired é usado para que o spring instancie "automaticamente" a injeção de dependência
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id.longValue());
        return cliente.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado. Id: "+id + ", Tipo: "+Cliente.class.getName()));
    }


}
