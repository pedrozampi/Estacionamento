package com.pzampi.estacionamento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.model.Residente;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{
    Optional<Entrada> findByPlaca(String placa);
    List<Entrada> findAllByOficial(Oficial obj);
    List<Entrada> findAllByResidente(Residente obj);

}
