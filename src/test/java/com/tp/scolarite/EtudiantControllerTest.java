package com.tp.scolarite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EtudiantControllerTest {

    @Mock EtudiantRepository repository;
    @InjectMocks EtudiantController controller;

    @Test
    void listerRetourneLesEtudiants() {
        when(repository.findAll())
            .thenReturn(List.of(new Etudiant("Mballa", "Jean", "jean@mail.cm")));

        List<Etudiant> resultat = controller.lister();

        assertEquals(1, resultat.size());
        assertEquals("Mballa", resultat.get(0).getNom());
    }
}