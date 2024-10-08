package com.pzampi.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzampi.estacionamento.model.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Long>{

}
