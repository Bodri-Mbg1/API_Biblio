package com.esiitech.bibliotheque.service;


import com.esiitech.bibliotheque.entity.Livre;
import com.esiitech.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
