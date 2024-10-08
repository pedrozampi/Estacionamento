package com.pzampi.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.service.OficialService;

@RestController
@RequestMapping(value = "/oficiais")
public class OficialControler {
    @Autowired
    private OficialService service;

    @GetMapping
    public ResponseEntity<List<Oficial>> findaAll(){
        List<Oficial> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
