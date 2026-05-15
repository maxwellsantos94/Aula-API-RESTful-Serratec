package br.com.serratec.exercaula5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.exercaula5.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

}
