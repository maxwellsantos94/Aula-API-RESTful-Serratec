package br.com.serratec.exercaula5.model;

import br.com.serratec.exercaula5.enums.Turno;
import jakarta.persistence.Entity;


@Entity
public class Gerente extends Empregado {

    private Double adicional;

    public Gerente(String cpf, Long id, String nome, double salario, Setor setor, Turno turno, Double adicional) {
        super(cpf, id, nome, salario, setor, turno);
        this.adicional = adicional;
    }

    public Double getAdicional() {
        return adicional;
    }

    public void setAdicional(Double adicional) {
        this.adicional = adicional;
    }

}
