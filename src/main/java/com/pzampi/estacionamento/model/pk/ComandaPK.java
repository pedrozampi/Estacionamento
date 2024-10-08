package com.pzampi.estacionamento.model.pk;

import com.pzampi.estacionamento.model.Entrada;
import com.pzampi.estacionamento.model.Saida;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ComandaPK {
    @ManyToOne
    @JoinColumn(name = "entrada_id")
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "saida_id")
    private Saida saida;

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
        result = prime * result + ((saida == null) ? 0 : saida.hashCode());
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
        ComandaPK other = (ComandaPK) obj;
        if (entrada == null) {
            if (other.entrada != null)
                return false;
        } else if (!entrada.equals(other.entrada))
            return false;
        if (saida == null) {
            if (other.saida != null)
                return false;
        } else if (!saida.equals(other.saida))
            return false;
        return true;
    }

    

}
