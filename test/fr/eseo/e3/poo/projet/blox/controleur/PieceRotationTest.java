package fr.eseo.e3.poo.projet.blox.controleur;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;

public class PieceRotationTest {
    @Test
    public void testPieceRotation() {
        Puits p1 = new Puits();
        p1.setPieceSuivante(new IPiece(new Coordonnees(3, 3), Couleur.ORANGE));
        p1.setPieceSuivante(new IPiece(new Coordonnees(3, 3), Couleur.ORANGE));
        System.err.println(p1.toString());
        try{
        p1.getPieceActuelle().tourner(false);
        }catch(Exception e) {
        }
        System.err.println(p1.toString());
        try{
        p1.getPieceActuelle().tourner(false);
        }catch(Exception e) {
        }
        System.err.println(p1.toString());
    }
}