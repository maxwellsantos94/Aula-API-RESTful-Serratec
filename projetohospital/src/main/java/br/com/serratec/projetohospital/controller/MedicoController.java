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

import br.com.serratec.projetohospital.model.Medico;
import br.com.serratec.projetohospital.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico inserir(@Valid @RequestBody Medico Medico) {
        return repository.save(Medico);
    }

    @PutMapping("{id}")
    public ResponseEntity<Medico> alterar(@Valid @RequestBody Medico Medico, @PathVariable Long id) {
        if (repository.existsById(id)) {
            Medico.setId(id);
            return ResponseEntity.ok(repository.save(Medico));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Long id) {
        Optional<Medico> Medico = repository.findById(id);

        if (Medico.isPresent()) {
            return ResponseEntity.ok(Medico.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Medico> listar() {
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
