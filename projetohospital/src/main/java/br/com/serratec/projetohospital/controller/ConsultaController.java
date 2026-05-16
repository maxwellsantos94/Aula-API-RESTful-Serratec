package br.com.serratec.projetohospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.projetohospital.model.Consulta;
import br.com.serratec.projetohospital.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta inserir(@Valid @RequestBody Consulta Consulta) {
        return repository.save(Consulta);
    }

    @PutMapping("{id}")
    public ResponseEntity<Consulta> alterar(@Valid @RequestBody Consulta Consulta, @PathVariable Long id) {
        if (repository.existsById(id)) {
            Consulta.setId(id);
            return ResponseEntity.ok(repository.save(Consulta));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Long id) {
        Optional<Consulta> Consulta = repository.findById(id);

        if (Consulta.isPresent()) {
            return ResponseEntity.ok(Consulta.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Consulta> listar() {
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
