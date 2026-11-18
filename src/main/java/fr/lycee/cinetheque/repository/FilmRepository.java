package fr.lycee.cinetheque.repository;

import fr.lycee.cinetheque.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository
        extends JpaRepository<Film, Long> {
}