package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	public static final double MULTIPLIER_TEINTE = 0.44;
	private final int taille;
	private final Piece piece;

	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
	}

	// Méthode qui permet de teinter les pièces du jeu
	public java.awt.Color teinte(java.awt.Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		r = (int) (r + (255 - r) * MULTIPLIER_TEINTE);
		g = (int) (g + (255 - g) * MULTIPLIER_TEINTE);
		b = (int) (b + (255 - b) * MULTIPLIER_TEINTE);
		return new java.awt.Color(r, g, b);
	}

	// Méthode qui permet d'afficher les pièces du jeu
	public void afficherPiece(java.awt.Graphics2D g2d) {
		// Boucle for pour créer l'affichage de toutes les cases de Elements.
		if (this.piece.getElements() != null) {
			for (int i = 0; i < this.piece.getElements().size(); i++) {
				if (i == 0) {
					g2d.setColor(this.teinte(this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage()));
					g2d.fill3DRect(this.piece.getElements().get(i).getCoordonnees().getAbscisse() * this.taille,
							this.piece.getElements().get(i).getCoordonnees().getOrdonnee() * this.taille, this.taille,
							this.taille, true);
				} else {
					g2d.setColor(this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage());
					g2d.fill3DRect(this.piece.getElements().get(i).getCoordonnees().getAbscisse() * this.taille,
							this.piece.getElements().get(i).getCoordonnees().getOrdonnee() * this.taille, this.taille,
							this.taille, true);
				}
			}
		} else {
			throw new Error("Erreur : la pièce n'a pas d'éléments");
		}
	}
}
