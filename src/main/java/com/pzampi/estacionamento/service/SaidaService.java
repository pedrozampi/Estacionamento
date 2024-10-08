package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.repository.SaidaRepository;

@Service
public class SaidaService {
    @Autowired
    private SaidaRepository repository;

    public List<Saida> findAll(){
        return repository.findAll();
    }

    public Saida findById(Long id){
        Optional<Saida> obj = repository.findById(id);
        return obj.get();
    }
}
