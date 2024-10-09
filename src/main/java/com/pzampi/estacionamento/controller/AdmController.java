package com.pzampi.estacionamento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.service.EntradaService;
import com.pzampi.estacionamento.service.OficialService;
import com.pzampi.estacionamento.service.ResidenteService;

import jakarta.websocket.server.PathParam;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private ResidenteService residenteService;

    @Autowired
    private OficialService oficialService;

    @PostMapping("/entrada")
    public ResponseEntity<Entrada> insert(@RequestBody Entrada obj) {
        obj = entradaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PostMapping(path = "/saida/{id}")
    public ResponseEntity<Entrada> setSaida(@PathVariable Long id){
        Entrada entrada = entradaService.setSaida(id);
        return ResponseEntity.ok().body(entrada);
    }

    @PostMapping("/oficial")
    public ResponseEntity<Oficial> insertOficial(@RequestBody Oficial obj) {
        obj = oficialService.insertOficial(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PostMapping("/residente")
    public ResponseEntity<Residente> insertResidente(@RequestBody Residente obj) {
        obj = residenteService.insertResidente(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/entrada/{id}")
    public ResponseEntity<Entrada> update(@PathVariable Long id, @RequestBody Entrada obj){
        obj = entradaService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/oficial/{id}")
    public ResponseEntity<Oficial> update(@PathVariable Long id, @RequestBody Oficial obj){
        obj = oficialService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    @PutMapping("/residente/{id}")
    public ResponseEntity<Residente> update(@PathVariable Long id, @RequestBody Residente obj){
        obj = residenteService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/saida/{id}")
    public ResponseEntity<Entrada> saida(@PathVariable Long id){
        Entrada obj = entradaService.saida(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/saida/undo/{id}")
    public ResponseEntity<Entrada> undsaida(@PathVariable Long id){
        Entrada obj = entradaService.resetSaida(id);
        return ResponseEntity.ok().body(obj);
    }


    @DeleteMapping("/oficial/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        oficialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/residente/{id}")
    public ResponseEntity<Void> deleteResidente(@PathVariable Long id){
        residenteService.delete(id);;
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/entrada/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id){
        entradaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/startmonth")
    public ResponseEntity<Void> startMonth(){
        entradaService.startMonth();
        return ResponseEntity.noContent().build();
    }
}
