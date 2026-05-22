package br.com.serratec.loja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.loja.model.LancamentoVendas;
import br.com.serratec.loja.repository.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<LancamentoVendas> listar() {
        return repository.findAll();
    }

    public Optional<LancamentoVendas> listarPorId(Long id){
        return repository.findById(id);
    }

    public LancamentoVendas inserir(LancamentoVendas lancamentoVendas) {
        return repository.save(lancamentoVendas);
    }

}
