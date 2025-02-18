package com.esiitech.bibliotheque.repository;

import com.esiitech.bibliotheque.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
