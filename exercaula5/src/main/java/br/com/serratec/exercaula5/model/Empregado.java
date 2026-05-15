package br.com.serratec.exercaula5.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.serratec.exercaula5.enums.Turno;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_vendedor", discriminatorType=DiscriminatorType.STRING)
@Entity
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "Nome obrigatório")
    @Size(min = 3, max = 100, message = "Nome inválido")
    protected String nome;

    @NotBlank(message = "CPF obrigatório")
    @CPF(message = "CPF inválido")
    protected String cpf;

    @NotNull
    @Positive
    protected double salario;

    @Enumerated(EnumType.STRING)
    protected Turno turno;

    @ManyToOne
    @JoinColumn(name="id_setor")
    @NotNull(message="Setor obrigatório")
    protected Setor setor;

    public Empregado(String cpf, Long id, String nome, double salario, Setor setor, Turno turno) {
        this.cpf = cpf;
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.setor = setor;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}
