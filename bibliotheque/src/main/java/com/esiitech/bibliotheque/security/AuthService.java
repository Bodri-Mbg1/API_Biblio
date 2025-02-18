package com.esiitech.bibliotheque.security;


import com.esiitech.bibliotheque.entity.Utilisateur;
import com.esiitech.bibliotheque.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String email, String password) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(email);

        if (utilisateurOpt.isPresent() && passwordEncoder.matches(password, utilisateurOpt.get().getMotDePasse())) {
            Utilisateur utilisateur = utilisateurOpt.get();
            return jwtUtil.generateToken(utilisateur.getEmail(), utilisateur.getRole().name());
        }
        throw new RuntimeException("Email ou mot de passe incorrect");
    }
}
