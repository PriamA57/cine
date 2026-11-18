package fr.lycee.cinetheque.controller;
import fr.lycee.cinetheque.entity.Film;
import fr.lycee.cinetheque.service.FilmService;
import fr.lycee.cinetheque.service.RealisateurService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;
    private final RealisateurService realisateurService;

    public FilmController(FilmService filmService,
        RealisateurService realisateurService){
        this.filmService = filmService;
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public String lister(Model model) {
        model.addAttribute("films", filmService.listerTous());
        return "films/liste";
    }

    @GetMapping("nouveau")
    public String formulaireCreattion(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("realisateurs", realisateurService.listerTous());
        return "films/formulaire";
    }

    @PostMapping
    public String enregistrer(@ModelAttribute Film film,
                              @RequestParam(required = false) Long realisateurId) {
        if (realisateurId != null) {
            film.setRealisateur(realisateurService.trouverParId(realisateurId));
        }
        filmService.enregistrer(film);
        return "redirect:/films";
    }

    @GetMapping("/{id}/editer")
    public String formulaireEdition(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmService.trouverParId(id));
        model.addAttribute("realisateurs", realisateurService.listerTous());
        return "films/formulaire";
    }

    @GetMapping("/{id}/supprimer")
    public String supprimer(@PathVariable Long id) {
        filmService.supprimer(id);
        return "redirect:/films";
    }
}
