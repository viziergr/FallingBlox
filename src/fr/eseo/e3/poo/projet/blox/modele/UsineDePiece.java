package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

// Import des différentes pieces du projet
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;

public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 3;

	private static int mode = ALEATOIRE_COMPLET;
	private static Random random = new Random();
	private static int indexForme = 0;

	private UsineDePiece() {
		// Constructeur vide pour empêcher l'instanciation de la classe
	}

	// Méthode qui permet de changer le mode de génération des pièces
	public static void setMode(int mode) {
		UsineDePiece.mode = mode;
	}

	// Méthode qui permet de générer une pièce en fonction du mode choisi
	public static Piece genererPiece() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		// mode cyclique qui fait défiler toutes les pièces dans l'ordre avec leur
		// couleur associée
		if (UsineDePiece.mode == CYCLIC) {
			piece = cyclic();
		}
		// Condition qui crée une pièce aléatoire de couleur aléatoire
		else if (UsineDePiece.mode == ALEATOIRE_COMPLET) {
			int couleur = random.nextInt(7);
			int intPiece = random.nextInt(7);
			piece = aleatoireComplet(couleur, intPiece);
		}
		// Condition qui crée une pièce aléatoire de la bonne couleur
		else {
			int intPiece = random.nextInt(7);
			piece = aleatoirePiece(intPiece);
		}
		return piece;
	}

	// Méthode qui permet de générer une pièce en fonction du mode choisi
	static private Piece cyclic() {
		Piece piece;
		switch (indexForme) {
			case 1:
				piece = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
				indexForme = 2;
				break;
			case 2:
				piece = new TPiece(new Coordonnees(2, 3), Couleur.BLEU);
				indexForme = 3;
				break;
			case 3:
				piece = new LPiece(new Coordonnees(2, 3), Couleur.VERT);
				indexForme = 4;
				break;
			case 4:
				piece = new JPiece(new Coordonnees(2, 3), Couleur.JAUNE);
				indexForme = 5;
				break;
			case 5:
				piece = new ZPiece(new Coordonnees(2, 3), Couleur.CYAN);
				indexForme = 6;
				break;
			case 6:
				piece = new SPiece(new Coordonnees(2, 3), Couleur.VIOLET);
				indexForme = 0;
				break;
			default:
				piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
				indexForme = 1;
				break;
		}
		return piece;
	}

	static private Piece aleatoireComplet(int couleur, int intPiece) {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		switch (intPiece) {
			case 1:
				piece = new IPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			case 2:
				piece = new TPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			case 3:
				piece = new LPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			case 4:
				piece = new JPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			case 5:
				piece = new ZPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			case 6:
				piece = new SPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
			default:
				piece = new OPiece(new Coordonnees(2, 3), Couleur.values()[couleur]);
				break;
		}
		return piece;
	}

	static private Piece aleatoirePiece(int intPiece) {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		switch (intPiece) {
			case 1:
				piece = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
				break;
			case 2:
				piece = new TPiece(new Coordonnees(2, 3), Couleur.BLEU);
				break;
			case 3:
				piece = new LPiece(new Coordonnees(2, 3), Couleur.VERT);
				break;
			case 4:
				piece = new JPiece(new Coordonnees(2, 3), Couleur.JAUNE);
				break;
			case 5:
				piece = new ZPiece(new Coordonnees(2, 3), Couleur.CYAN);
				break;
			case 6:
				piece = new SPiece(new Coordonnees(2, 3), Couleur.VIOLET);
				break;
			default:
				piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
				break;
		}
		return piece;
	}

	public static int getMode() {
		return mode;
	}
	
}
