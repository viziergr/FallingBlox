package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class PieceDeplacementTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PieceDeplacementTest();
            }
        });
    }

    public PieceDeplacementTest() {
        testDeplacementPiece();
    }

    public void testDeplacementPiece() {
        JFrame j1 = new JFrame();
        Puits p1 = new Puits();
        VuePuits vP = new VuePuits(p1);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.setTitle("Puits");
        j1.getContentPane().add(vP);
        p1.setPieceSuivante(new OPiece(new Coordonnees(1, 18), Couleur.ORANGE));
        p1.setPieceSuivante(new IPiece(new Coordonnees(2, 2), Couleur.ORANGE));
        p1.getPieceActuelle().setPosition(8, 19);
        
        j1.pack();
        j1.setLocationRelativeTo(null);
        j1.setVisible(true);
    }
}