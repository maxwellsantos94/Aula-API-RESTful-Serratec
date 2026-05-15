package br.com.serratec.exercaula5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.exercaula5.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

}
