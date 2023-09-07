package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Color;

public class CouleurTest {

    @Test
    void testGetCouleurPourAffichage() {
        // arrange
        Couleur rouge = Couleur.ROUGE;
        Couleur orange = Couleur.ORANGE;
        Couleur bleu = Couleur.BLEU;
        Couleur vert = Couleur.VERT;
        Couleur jaune = Couleur.JAUNE;
        Couleur cyan = Couleur.CYAN;
        Couleur violet = Couleur.VIOLET;

        // act
        Color couleurRouge = rouge.getCouleurPourAffichage();
        Color couleurOrange = orange.getCouleurPourAffichage();
        Color couleurBleu = bleu.getCouleurPourAffichage();
        Color couleurVert = vert.getCouleurPourAffichage();
        Color couleurJaune = jaune.getCouleurPourAffichage();
        Color couleurCyan = cyan.getCouleurPourAffichage();
        Color couleurViolet = violet.getCouleurPourAffichage();

        // assert
        Assertions.assertEquals(Color.RED, couleurRouge);
        Assertions.assertEquals(Color.ORANGE, couleurOrange);
        Assertions.assertEquals(Color.BLUE, couleurBleu);
        Assertions.assertEquals(Color.GREEN, couleurVert);
        Assertions.assertEquals(Color.YELLOW, couleurJaune);
        Assertions.assertEquals(Color.CYAN, couleurCyan);
        Assertions.assertEquals(Color.MAGENTA, couleurViolet);
    }
}
