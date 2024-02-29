package com.example.Test.controller;

import com.example.Test.domain.Carte;
import com.example.Test.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jeu")
public class JeuCarteController {
    @Autowired
    private JeuService jeuDeCartesService;

    @GetMapping("/nouveau")
    public List<Carte> obtenirNouveauJeuDeCartesMelange() {

        return jeuDeCartesService.genererJeuDeCartesMelange();
    }

    @GetMapping("/tirer-main")
    public List<Carte> tirerMain() {
        List<Carte> jeuDeCartes = jeuDeCartesService.genererJeuDeCartesMelange();
        return jeuDeCartesService.tirerMainDeCartes(jeuDeCartes, 10);
    }

    @GetMapping("/tirer-main-triee")
    public List<Carte> tirerMainTriee() {
        List<Carte> jeuDeCartes = jeuDeCartesService.genererJeuDeCartesMelange();
        List<Carte> main = jeuDeCartesService.tirerMainDeCartes(jeuDeCartes, 10);
        return jeuDeCartesService.trierMain(main);
    }
}
