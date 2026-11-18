package fr.lycee.cinetheque.controller;

import fr.lycee.cinetheque.entity.Realisateur;
import fr.lycee.cinetheque.service.RealisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping
    public String lister(Model model) {
        model.addAttribute("realisateurs", service.listerTous());
        return "realisateurs/liste";
    }

    @GetMapping("/nouveau")
    public String formulaire(Model model) {
        model.addAttribute("realisateur", new Realisateur());
        return "realisateurs/formulaire";
    }

    @PostMapping
    public String enregistrer(@ModelAttribute Realisateur realisateur) {
        service.enregistrer(realisateur);
        return "redirect:/realisateurs";
    }
}