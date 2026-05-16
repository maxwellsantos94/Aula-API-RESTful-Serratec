package br.com.serratec.projetohospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.projetohospital.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
