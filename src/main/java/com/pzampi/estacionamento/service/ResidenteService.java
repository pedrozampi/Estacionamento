package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.repository.ResidenteRepository;

@Service
public class ResidenteService {
    @Autowired
    private ResidenteRepository repository;

    public List<Residente> findAll(){
        return repository.findAll();
    }

    public Residente findById(Long id){
        Optional<Residente> obj = repository.findById(id);
        return obj.get();
    }

    public Residente insertResidente(Residente obj){
        return obj = repository.save(obj);
    }

    public Residente update(Long id, Residente obj){
        try{
            Residente entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch(Exception e){    
            e.printStackTrace();
        }
        return null;
    }

    private void updateData(Residente entity, Residente obj) {
        entity.setPlaca(obj.getPlaca());
    }
}
