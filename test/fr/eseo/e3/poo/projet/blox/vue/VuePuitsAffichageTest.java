package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class VuePuitsAffichageTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		});
	}

	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}

	private void testConstructeurPuits() {
		JFrame j1 = new JFrame();
		Puits p1 = new Puits();
		p1.setPieceSuivante(new OPiece(new Coordonnees(1, 1), Couleur.ROUGE));
		p1.setPieceSuivante(new OPiece(new Coordonnees(1, 1), Couleur.ROUGE));
		VuePuits vP = new VuePuits(p1);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setTitle("Puits");
		j1.add(vP);
		j1.pack();
		j1.setLocationRelativeTo(null);
		j1.setVisible(true);
	}

	private void testConstructeurPuitsTaille() {
		JFrame j2 = new JFrame("Puits");
		Puits p2 = new Puits(5, 22);
		p2.setPieceSuivante(new OPiece(new Coordonnees(1, 1), Couleur.ROUGE));
		p2.setPieceSuivante(new OPiece(new Coordonnees(1, 1), Couleur.ROUGE));
		VuePuits vP = new VuePuits(p2, 16);
		//VuePiece vuePiece = new VuePiece(new OPiece(new Coordonnees(2, 20), Couleur.ROUGE), 16);
		//vP.setVuePiece(vuePiece);
		j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j2.setTitle("Puits et taille");
		j2.add(vP);
		j2.pack();
		j2.setLocationRelativeTo(null);
		j2.setVisible(true);
	}
}