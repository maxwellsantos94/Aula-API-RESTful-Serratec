package br.com.serratec.loja.dto;

import java.time.LocalDate;

import br.com.serratec.loja.model.LancamentoVendas;

public class LancamentoVendasResponseDTO {

    private LocalDate dataVenda;
    private Double valorVenda;
    private String nomeVendedor;

    public LancamentoVendasResponseDTO() {
    }

    public LancamentoVendasResponseDTO(LancamentoVendas lancamento) {
        this.dataVenda = lancamento.getData();
        this.valorVenda = lancamento.getValor();
        this.nomeVendedor = lancamento.getVendedor() != null ? lancamento.getVendedor().getNome() : null;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

}
