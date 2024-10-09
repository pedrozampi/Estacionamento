package com.pzampi.estacionamento.config;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Oficial;
import com.pzampi.estacionamento.model.Residente;
import com.pzampi.estacionamento.model.Saida;
import com.pzampi.estacionamento.repository.EntradaRepository;
import com.pzampi.estacionamento.repository.OficialRepository;
import com.pzampi.estacionamento.repository.ResidenteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private OficialRepository oficialRepository;

    @Autowired
    private ResidenteRepository residenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Residente r1 = new Residente(null, "GUT4037");
        residenteRepository.save(r1);

        Oficial of1 = new Oficial(null, "AEH9493");
        oficialRepository.save(of1);

        Entrada e1 = new Entrada(null, "GUT4037",null,null);
        e1.setResidente(r1);
        entradaRepository.save(e1);

        Entrada e2 = new Entrada(null, "AEH9493",null,null);
        e2.setOficial(of1);;
        entradaRepository.save(e2);

        Saida s1 = new Saida(null,e1);
        s1.setMoment(s1.getMoment().plus(3, ChronoUnit.HOURS));
        e1.setSaida(s1);
        entradaRepository.save(e1);

        Saida s2 = new Saida(null,e2);
        s2.setMoment(s2.getMoment().plus(3, ChronoUnit.HOURS));
        e2.setSaida(s2);
        entradaRepository.save(e2);



        
        //entradaRepository.save(e1);
        
    }

}
