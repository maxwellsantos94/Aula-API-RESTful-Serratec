package br.com.serratec.projetohospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.projetohospital.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
