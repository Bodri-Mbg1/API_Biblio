package com.esiitech.bibliotheque.service;


import com.esiitech.bibliotheque.entity.Utilisateur;
import com.esiitech.bibliotheque.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse())); // Encodage du mot de passe
        return utilisateurRepository.save(utilisateur);
    }


    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }


}
