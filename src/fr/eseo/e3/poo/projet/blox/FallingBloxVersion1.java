package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.controleur.DeplacementClavier;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {
	private FallingBloxVersion1() {

	}

	public static void main(String[] args) {
		// Si le programme est lancé sans argument, on lance le jeu normalement :
		JFrame j1 = new JFrame();
		Puits p1 = new Puits();
		if (args.length == 0) {
			VuePuits vP = new VuePuits(p1,30);
			vP.setGravite(new Gravite(vP));
			setJ1(j1, vP, p1);
			p1.setPieceSuivante(UsineDePiece.genererPiece());
			p1.setPieceSuivante(UsineDePiece.genererPiece());
		} else if (args.length == 1) {
			Tas tas = new Tas(p1, Integer.parseInt(args[0]));
			p1.setTas(tas);
			VuePuits vP = new VuePuits(p1);
			vP.setGravite(new Gravite(vP));
			setJ1(j1, vP, p1);
			p1.setPieceSuivante(UsineDePiece.genererPiece());
			p1.setPieceSuivante(UsineDePiece.genererPiece());
		} else if (args.length == 2) {
			Tas tas = new Tas(p1, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			p1.setTas(tas);
			VuePuits vP = new VuePuits(p1);
			vP.setGravite(new Gravite(vP));
			setJ1(j1, vP, p1);
			p1.setPieceSuivante(UsineDePiece.genererPiece());
			p1.setPieceSuivante(UsineDePiece.genererPiece());
		} else {
		}
	}

	static public void setJ1(JFrame j1, VuePuits vP, Puits p1) {
		DeplacementClavier dc = new DeplacementClavier(vP);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setTitle("Falling Blox");
		j1.addKeyListener(dc);
		j1.getContentPane().add(vP);
		j1.getContentPane().add(new PanneauInformation(p1), BorderLayout.EAST);
		j1.setResizable(false);
		j1.pack();
		j1.setLocationRelativeTo(null);
		j1.setVisible(true);
	}
}
