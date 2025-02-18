package com.esiitech.bibliotheque.service;


import com.esiitech.bibliotheque.entity.Emprunt;
import com.esiitech.bibliotheque.entity.Livre;
import com.esiitech.bibliotheque.entity.Utilisateur;
import com.esiitech.bibliotheque.repository.EmpruntRepository;
import com.esiitech.bibliotheque.repository.LivreRepository;
import com.esiitech.bibliotheque.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private LivreRepository livreRepository;

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    public Emprunt emprunterLivre(Long utilisateurId, Long livreId) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(utilisateurId);
        Optional<Livre> livreOpt = livreRepository.findById(livreId);

        if (utilisateurOpt.isPresent() && livreOpt.isPresent()) {
            Livre livre = livreOpt.get();
            if (livre.getNombreExemplaires() > 0) {
                livre.setNombreExemplaires(livre.getNombreExemplaires() - 1);
                livreRepository.save(livre);

                Emprunt emprunt = new Emprunt();
                emprunt.setUtilisateur(utilisateurOpt.get());
                emprunt.setLivre(livre);
                emprunt.setDateEmprunt(LocalDate.now());
                return empruntRepository.save(emprunt);
            } else {
                throw new RuntimeException("Aucun exemplaire disponible !");
            }
        } else {
            throw new RuntimeException("Utilisateur ou Livre introuvable !");
        }
    }

    public void retournerLivre(Long empruntId) {
        Optional<Emprunt> empruntOpt = empruntRepository.findById(empruntId);
        if (empruntOpt.isPresent()) {
            Emprunt emprunt = empruntOpt.get();
            emprunt.setDateRetour(LocalDate.now());

            Livre livre = emprunt.getLivre();
            livre.setNombreExemplaires(livre.getNombreExemplaires() + 1);
            livreRepository.save(livre);

            empruntRepository.save(emprunt);
        } else {
            throw new RuntimeException("Emprunt introuvable !");
        }
    }
}
