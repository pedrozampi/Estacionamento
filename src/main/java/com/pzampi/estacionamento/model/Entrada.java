package com.pzampi.estacionamento.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entradas")
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment = Instant.now();
    private String placa;

    @OneToOne(mappedBy = "entrada", cascade = CascadeType.ALL)
    private Saida saida;

    private Integer hours = 0;
    private Double total = 0.0;

    @ManyToOne
    @JoinColumn(name = "residente_id", nullable = true)
    private Residente residente;

    @ManyToOne
    @JoinColumn(name = "oficial_id", nullable = true)
    private Oficial oficial;

    public Entrada() {
    }

    public Entrada(Long id, String placa, Residente residente, Oficial oficial) {
        this.id = id;
        this.placa = placa;
        this.residente = residente;
        this.oficial = oficial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getHours() {
        if (saida != null) {
            if (oficial != null) {
                hours = 0;
                return hours;
            }
            Duration res = Duration.between(moment, saida.getMoment());
            hours = res.toHoursPart();
            return hours;
        }
        return hours;
    }

    @JsonIgnore
    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    @JsonIgnore
    public Oficial getOficial() {
        return oficial;
    }

    public void setOficial(Oficial oficial) {
        this.oficial = oficial;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        if (oficial != null)
            return 0.0;
        if (hours != null)
            total = hours * 10.0;
        else
            return total;
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entrada other = (Entrada) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
