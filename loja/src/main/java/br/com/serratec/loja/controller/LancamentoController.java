package br.com.serratec.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.loja.dto.LancamentoVendasResponseDTO;
import br.com.serratec.loja.model.LancamentoVendas;
import br.com.serratec.loja.service.LancamentoService;

@RestController
@RequestMapping("/vendas")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    // @GetMapping("{id}")
    // public ResponseEntity<LancamentoVendas> buscar(@PathVariable Long id) {
    //     Optional<LancamentoVendas> LancamentoVendas = service.listarPorId(id);
    //     if (LancamentoVendas.isPresent()) {
    //         return ResponseEntity.ok(LancamentoVendas.get());
    //     }
    //     return ResponseEntity.notFound().build();
    // }
    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> buscar(@PathVariable Long id) {
        return service.listarPorId(id)
            .map(lancamento -> ResponseEntity.ok(new LancamentoVendasResponseDTO(lancamento)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendas inserir(@RequestBody LancamentoVendas lancamentoVendas) {
        return service.inserir(lancamentoVendas);
    }

}
