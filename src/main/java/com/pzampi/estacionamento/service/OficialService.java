package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.repository.OficialRepository;

@Service
public class OficialService {
    @Autowired
    private OficialRepository repository;

    public List<Oficial> findAll(){
        return repository.findAll();
    }

    public Oficial findById(Long id){
        Optional<Oficial> obj = repository.findById(id);
        return obj.get();
    }

    public Oficial insertOficial(Oficial obj){
        return obj = repository.save(obj);
    }

    public Oficial update(Long id, Oficial obj){
        try{
            Oficial entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch(Exception e){    
            e.printStackTrace();
        }
        return null;
    }

    private void updateData(Oficial entity, Oficial obj) {
        entity.setPlaca(obj.getPlaca());
    }
}
