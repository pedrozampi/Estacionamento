package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.repository.EntradaRepository;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;

    public List<Entrada> findAll(){
        return repository.findAll();
    }

    public Entrada findById(Long id){
        Optional<Entrada> obj = repository.findById(id);
        return obj.get();
    }
}
