package br.com.serratec.projetohospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.projetohospital.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
