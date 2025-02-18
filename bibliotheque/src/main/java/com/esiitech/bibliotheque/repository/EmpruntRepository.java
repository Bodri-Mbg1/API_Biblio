package com.esiitech.bibliotheque.repository;

import com.esiitech.bibliotheque.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}