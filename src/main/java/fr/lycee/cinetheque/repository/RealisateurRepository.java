package fr.lycee.cinetheque.repository;

import fr.lycee.cinetheque.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisateurRepository
        extends JpaRepository<Realisateur, Long> {
}