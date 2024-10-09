package com.pzampi.estacionamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.estacionamento.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{
    Optional<Entrada> findByPlaca(String placa);
}
