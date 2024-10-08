package com.pzampi.estacionamento.config;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.repository.EntradaRepository;
import com.pzampi.estacionamento.repository.SaidaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SaidaRepository saidaRepository;

    @Override
    public void run(String... args) throws Exception {
        Entrada e1 = new Entrada(null, "AEH9493");
        Saida s1 = new Saida(null, "AEH9493");

        entradaRepository.save(e1);
        s1.setMoment(s1.getMoment().plus(3, ChronoUnit.HOURS));;
        saidaRepository.save(s1);
    }

}
