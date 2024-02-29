package com.example.Test.service;

import com.example.Test.domain.Carte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class JeuService {
    private final String[] couleurs = {"Carreaux", "Coeur", "Pique", "Trèfle"};
    private final String[] valeurs = {"As", "5", "10", "8", "6", "7", "4", "2", "3", "9", "Dame", "Roi", "Valet"};

    public List<Carte> genererJeuDeCartesMelange() {
        List<Carte> jeuDeCartes = new ArrayList<>();
        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                jeuDeCartes.add(new Carte(couleur, valeur));
            }
        } // Mélanger le jeu de cartes
        Collections.shuffle(jeuDeCartes);
        return jeuDeCartes;
    }

    public List<Carte> tirerMainDeCartes(List<Carte> jeuDeCartes, int nombreDeCartes) {
        List<Carte> main = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < nombreDeCartes; i++) {
            if (jeuDeCartes.isEmpty()) {
                break;
                // Il n'y a plus de cartes dans le jeu
            }
            int index = random.nextInt(jeuDeCartes.size());
            main.add(jeuDeCartes.remove(index));
        }
        return main;
    }

    public List<Carte> trierMain(List<Carte> main) {
        // Triez la main par couleur puis par valeur
        Collections.sort(main, (carte1, carte2) -> {
            int compareCouleur = carte1.getCouleur().compareTo(carte2.getCouleur());
            if (compareCouleur == 0) {
                return carte1.getValeur().compareTo(carte2.getValeur());
            }
            return compareCouleur;
        });
        return main;
    }
}