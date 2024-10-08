package com.pzampi.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.service.ResidenteService;

@RestController
@RequestMapping(value = "/residentes")
public class ResidenteControler {
    @Autowired
    private ResidenteService service;

    @GetMapping
    public ResponseEntity<List<Residente>> findaAll(){
        List<Residente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
