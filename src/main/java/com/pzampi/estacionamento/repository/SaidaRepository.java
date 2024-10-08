package com.pzampi.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.estacionamento.model.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{

}
