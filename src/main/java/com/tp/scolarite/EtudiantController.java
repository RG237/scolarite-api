package com.tp.scolarite;

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
}