package com.pzampi.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.service.SaidaService;

@RestController
@RequestMapping(value = "/saidas")
public class SaidaControler {
    @Autowired
    private SaidaService service;

    @GetMapping
    public ResponseEntity<List<Saida>> findaAll(){
        List<Saida> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
