package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 20;
	public static final String MODIFICATION_PIECE_ACTUELLE = "modif_piece_actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "modif_piece_suivante";

	private PropertyChangeSupport pcs;
	private int largeur;
	private int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private Tas tas;
	private int score = 0;
	private int niveau = 0;

	public Puits(int largeur, int hauteur) {
		if (largeur < 5 || largeur > 15 || hauteur < 15 || hauteur > 25) {
			throw new IllegalArgumentException("La largeur doit etre entre 5 et 15" + " et la hauteur entre 15 et 25");
		} else {
			this.largeur = largeur;
			this.profondeur = hauteur;
			this.pcs = new PropertyChangeSupport(this);
			this.tas = new Tas(this);
		}
	}

	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		this(largeur, profondeur);
		this.setTas(new Tas(this, nbElements, nbLignes));
	}

	public Puits() {
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
		this.pcs = new PropertyChangeSupport(this);
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		if (largeur < 5 || largeur > 15) {
			throw new IllegalArgumentException("La largeur doit etre entre 5 et 15" + " et la hauteur entre 15 et 25");
		} else {
			this.largeur = largeur;
		}
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25) {
			throw new IllegalArgumentException("La largeur doit etre entre 5 et 15" + " et la hauteur entre 15 et 25");
		} else {
			this.profondeur = profondeur;
		}
	}

	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		if (this.pieceSuivante != null) {
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, this.pieceActuelle, getPieceSuivante());
			this.setPieceActuelle(this.pieceSuivante);
			this.getPieceActuelle().setPosition(this.getLargeur() / 2, -4);
		}
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.pieceSuivante, pieceSuivante);
		this.pieceSuivante = pieceSuivante;
		this.pieceSuivante.setPuits(this);
	}

	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}

	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	public Tas getTas() {
		return this.tas;
	}

	public void setTas(Tas tas) {
		this.tas = tas;
	}

	public PropertyChangeSupport getPcs() {
		return pcs;
	}

	public String toString() {
		String ret = "Puits : Dimension " + this.getLargeur() + " x " + this.getProfondeur() + "\n";
		if (this.getPieceActuelle() != null) {
			ret += "Piece Actuelle : " + this.getPieceActuelle().toString();
		}

		else {
			ret += "Piece Actuelle : <aucune>\n";
		}

		if (this.getPieceSuivante() != null) {
			ret += "Piece Suivante : " + this.getPieceSuivante().toString();
		}

		else {
			ret += "Piece Suivante : <aucune>\n";
		}
		return ret;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	private void gererCollision() {
		try {
			this.tas.ajouterElements(this.pieceActuelle);
			this.setPieceSuivante(UsineDePiece.genererPiece());
		} catch (Exception e) {
		}
	}

	public boolean ligneEstCompletee(int indiceLigne) {
		if (indiceLigne > this.getProfondeur()) {
			throw new IllegalArgumentException();
		} else {
			int nb = 0;
			for (int i = 0; i < this.getLargeur(); i++) {
				if (this.getTas().getElements()[indiceLigne][i] != null) {
					nb++;
				}
			}
			return (nb == this.getLargeur());	
		}
	}

	public void supprimerLigne(int indiceLigne) {
		if (indiceLigne > this.getProfondeur()) {
			throw new IllegalArgumentException();
		} else {
			// Supprimer tous les éléments de la ligne à supprimer
			for (int i = 0; i < this.getLargeur(); i++) {
				this.getTas().getElements()[indiceLigne][i] = null;
			}
			// Décaler toutes les lignes d'une ligne vers le bas
			for (int i = indiceLigne; i > 0; i--) {
				for (int j = 0; j < this.getLargeur(); j++) {
					this.getTas().getElements()[i][j] = this.getTas().getElements()[i - 1][j];
				}
			}
			// Ajouter une ligne vide en haut
			for (int i = 0; i < this.getLargeur(); i++) {
				this.getTas().getElements()[0][i] = null;
			}
		}
	}

	public void gravite() {
		if (getPieceActuelle() != null) {
			try {
				getPieceActuelle().deplacerDe(0, 1);
			} catch (BloxException e) {
				gererCollision();
			}
		}
		else {
			throw new IllegalArgumentException("Il n'y a pas de PieceActuelle");
		}
	}

	public void ajouterScore(int s) {
		this.score += s;
	}

	public int getScore() {
		return this.score;
	}

	public int getNiveau() {
		return this.niveau;
	}

	public int augmenterNiveau() {
		return this.niveau++;
	}

	//Méthode qui inverse la pièce actuelle et la piece suivante
	public void inversePiece(){
		if(this.pieceActuelle!=null){
			Piece tmp = this.getPieceActuelle();
			int x = this.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse();
			int y = this.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee();
			this.setPieceSuivante(tmp);
			this.pieceActuelle.setPosition(x,y);
			this.pieceSuivante.setPosition(2,3);
		}
	}

	public Piece clone(){
		String type = this.getPieceActuelle().getType();
		Piece ret = null;
		switch (type) {
			case "I":
				ret = new IPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			case "J":
				ret = new JPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			case "L":
				ret = new LPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			case "S":
				ret = new SPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			case "T":
				ret = new TPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			case "Z":
				ret = new ZPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
			default:
				ret = new OPiece(this.getPieceActuelle().getElements().get(0).getCoordonnees(),
						this.getPieceActuelle().getElements().get(0).getCouleur());
				break;
		}
		return ret;
	}
}