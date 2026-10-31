package com.tp.scolarite;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantRepository repository;

    public EtudiantController(EtudiantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Etudiant> lister() { return repository.findAll(); }

    @PostMapping
    public Etudiant creer(@RequestBody Etudiant etudiant) {
        return repository.save(etudiant);
    }
    @GetMapping("/{id}")
public Etudiant trouver(@PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
}
}