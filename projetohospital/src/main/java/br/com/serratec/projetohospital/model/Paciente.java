package br.com.serratec.projetohospital.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa {

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;


    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}