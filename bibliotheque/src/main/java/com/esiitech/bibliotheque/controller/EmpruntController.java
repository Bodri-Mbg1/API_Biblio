package com.esiitech.bibliotheque.controller;


import com.esiitech.bibliotheque.entity.Emprunt;
import com.esiitech.bibliotheque.service.EmpruntService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/emprunts")
@Tag(name = "Emprunt", description = "Gestion des emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    @Operation(summary = "Lister tous les emprunts")
    public List<Emprunt> getAllEmprunts() {
        return empruntService.getAllEmprunts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un emprunt par ID")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        return empruntService.getEmpruntById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/emprunter/{utilisateurId}/{livreId}")
    @Operation(summary = "Ajouter un emprunt")
    public ResponseEntity<Emprunt> emprunterLivre(@PathVariable Long utilisateurId, @PathVariable Long livreId) {
        try {
            Emprunt emprunt = empruntService.emprunterLivre(utilisateurId, livreId);
            return ResponseEntity.ok(emprunt);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/retourner/{empruntId}")
    @Operation(summary = "Modifier un emprunt")
    public ResponseEntity<Void> retournerLivre(@PathVariable Long empruntId) {
        try {
            empruntService.retournerLivre(empruntId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
