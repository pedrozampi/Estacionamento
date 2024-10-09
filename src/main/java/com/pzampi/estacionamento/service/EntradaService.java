package com.pzampi.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.repository.EntradaRepository;
import com.pzampi.estacionamento.repository.OficialRepository;
import com.pzampi.estacionamento.repository.ResidenteRepository;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;

    @Autowired
    private ResidenteRepository residenteRepository;

    @Autowired
    private OficialRepository oficialRepository;

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

    public Entrada saida(Long id){
        try{
            Entrada entity = repository.getReferenceById(id);
            updateSaida(entity);
            return repository.save(entity);
        }catch(Exception e){    
            e.printStackTrace();
        }
        return null;
    }

    private void updateSaida(Entrada entity) {
        entity.setSaida(new Saida(null, entity));
    }

    public Entrada resetSaida(Long id){
        try{
            Entrada entity = repository.getReferenceById(id);
            undoSaida(entity);
            return repository.save(entity);
        }catch(Exception e){    
            e.printStackTrace();
        }
        return null;
    }

    private void undoSaida(Entrada entity) {
        entity.setSaida(null);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
        }
   }

   public void startMonth(){
        List<Oficial> listOficial = oficialRepository.findAll();
        for(Oficial o: listOficial){
            List<Entrada> comandas = repository.findAllByOficial(o);
            for(Entrada e: comandas){
                repository.delete(e);
            }
        }

        List<Residente> listResidente = residenteRepository.findAll();
        for(Residente r: listResidente){
            List<Entrada> comandas = repository.findAllByResidente(r);
            for(Entrada e: comandas){
                repository.delete(e);
            }
        }
   }

}
