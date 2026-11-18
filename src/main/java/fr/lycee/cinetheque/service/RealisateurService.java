package fr.lycee.cinetheque.service;
import fr.lycee.cinetheque.entity.Realisateur;
import fr.lycee.cinetheque.repository.RealisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    // Pas de new
    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }
    public List<Realisateur> listerTous() {
        return realisateurRepository.findAll();
    }
    public Realisateur enregistrer(Realisateur r) {
        return realisateurRepository.save(r);
    }
    public Realisateur trouverParId(Long id) {
        return realisateurRepository.findById(id).orElseThrow();
    }
}
