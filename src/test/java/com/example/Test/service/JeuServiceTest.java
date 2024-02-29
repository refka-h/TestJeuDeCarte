package com.example.Test.service;

import com.example.Test.domain.Carte;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JeuServiceTest {

    @Mock
    private JeuService jeuService;

    @Test
    public void testGenererJeuDeCartesMelange() {
        List<Carte> jeuDeCartes = new ArrayList<>();
        // Ajouter des cartes au jeu de cartes simulé
        when(jeuService.genererJeuDeCartesMelange()).thenReturn(jeuDeCartes);

        List<Carte> result = jeuService.genererJeuDeCartesMelange();
    }

    @Test
    public void testTirerMainDeCartes() {
        // Créez un jeu de cartes simulé et un nombre de cartes à tirer
        List<Carte> jeuDeCartes = new ArrayList<>();
        int nombreDeCartes = 5; // Nombre de cartes à tirer

        when(jeuService.tirerMainDeCartes(jeuDeCartes, nombreDeCartes)).thenCallRealMethod();

        List<Carte> result = jeuService.tirerMainDeCartes(jeuDeCartes, nombreDeCartes);
    }

    @Test
    public void testTrierMain() {
        // Créez une main de cartes simulée à trier
        List<Carte> main = new ArrayList<>();

        when(jeuService.trierMain(main)).thenCallRealMethod();

        List<Carte> result = jeuService.trierMain(main);
    }
}
