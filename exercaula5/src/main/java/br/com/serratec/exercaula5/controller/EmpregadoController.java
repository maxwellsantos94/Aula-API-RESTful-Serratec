package br.com.serratec.exercaula5.controller;

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

import br.com.serratec.exercaula5.model.Empregado;
import br.com.serratec.exercaula5.repository.EmpregadoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

    @Autowired
    private EmpregadoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empregado inserir(@Valid @RequestBody Empregado Empregado) {
        return repository.save(Empregado);
    }

    @PutMapping("{id}")
    public ResponseEntity<Empregado> alterar(@Valid @RequestBody Empregado Empregado, @PathVariable Long id) {
        if (repository.existsById(id)) {
            Empregado.setId(id);
            return ResponseEntity.ok(repository.save(Empregado));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Empregado> buscar(@PathVariable Long id) {
        Optional<Empregado> Empregado = repository.findById(id);

        if (Empregado.isPresent()) {
            return ResponseEntity.ok(Empregado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Empregado> listar() {
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
