package br.com.serratec.loja.dto;

import java.time.LocalDate;

import br.com.serratec.loja.model.LancamentoVendas;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor) {

    public LancamentoVendasResponseDTO(LancamentoVendas lancamento) {
        this(
            lancamento.getData(), 
            lancamento.getValor(), 
            lancamento.getVendedor() != null ? lancamento.getVendedor().getNome() : null);
    }

}
