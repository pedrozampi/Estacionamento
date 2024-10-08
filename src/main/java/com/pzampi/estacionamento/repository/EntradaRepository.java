package com.pzampi.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.estacionamento.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{

}
