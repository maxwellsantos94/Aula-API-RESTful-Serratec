package br.com.serratec.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.loja.model.LancamentoVendas;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {

}
