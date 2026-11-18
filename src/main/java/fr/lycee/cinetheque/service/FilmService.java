package fr.lycee.cinetheque.service;
import fr.lycee.cinetheque.entity.Film;
import fr.lycee.cinetheque.repository.FilmRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public List<Film> listerTous() {
        return filmRepository.findAll();
    }
    public Film trouverParId(Long id) {
        return filmRepository.findById(id).orElseThrow();
    }
    public Film enregistrer(Film film) {
        return filmRepository.save(film);
    }
    public void supprimer(Long id) {
        filmRepository.deleteById(id);
    }
}