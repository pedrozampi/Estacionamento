package com.pzampi.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.service.EntradaService;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaControler {
    @Autowired
    private EntradaService service;

    @GetMapping
    public ResponseEntity<List<Entrada>> findaAll(){
        List<Entrada> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
