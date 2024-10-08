package com.pzampi.estacionamento.model;

import java.io.Serializable;

import com.pzampi.estacionamento.model.pk.ComandaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ComandaPK id = new ComandaPK();

    private Integer totalHoras;
    private Double totalPagar;
    public Comanda() {
    }
    public Comanda(Integer totalHoras, Double totalPagar) {
        this.totalHoras = totalHoras;
        this.totalPagar = totalPagar;
    }
    public Integer getTotalHoras() {
        return totalHoras;
    }
    public void setTotalHoras(Integer totalHoras) {
        this.totalHoras = totalHoras;
    }
    public Double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    
}
