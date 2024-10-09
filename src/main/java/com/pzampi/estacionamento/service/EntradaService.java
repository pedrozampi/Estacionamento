package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.repository.EntradaRepository;
import com.pzampi.estacionamento.repository.ResidenteRepository;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;

    @Autowired
    private ResidenteRepository residenteRepository;

    public List<Entrada> findAll(){
        return repository.findAll();
    }

    public Entrada findById(Long id){
        Optional<Entrada> obj = repository.findById(id);
        return obj.get();
    }

    public Entrada findByPlate(String placa){
        Optional<Entrada> obj = repository.findByPlaca(placa);
        return obj.get();
    }

    public Entrada insert(Entrada obj){
        return obj = repository.save(obj);
    }

    public Entrada setSaida(Long id){
        try{
            Optional<Entrada> entrada = repository.findById(id);
            Entrada res = entrada.get();
            res.setSaida(new Saida(null, res));
            return repository.save(res);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Entrada update(Long id, Entrada obj){
        try{
            Entrada entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch(Exception e){    
            e.printStackTrace();
        }
        return null;
    }

    private void updateData(Entrada entity, Entrada obj) {
        entity.setPlaca(obj.getPlaca());
    }


}
