package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 15;
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private VuePieceFantome vuePieceFantome;
	private final VueTas vueTas;
	public Gravite gravite;

	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		Dimension dimension = new Dimension(puits.getLargeur() * this.taille, puits.getProfondeur() * this.taille);
		setPreferredSize(dimension);
		setBackground(Color.white);
		this.vueTas = new VueTas(this);
		this.puits.addPropertyChangeListener(this);
		PieceDeplacement pieceDeplacement = new PieceDeplacement(this);
		PieceRotation pieceRotation = new PieceRotation(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.gravite = null;
	}

	public VuePuits(Puits puits) {
		this(puits, TAILLE_PAR_DEFAUT);
	}

	public Puits getPuits() {
		return this.puits;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		Dimension dimension = new Dimension(puits.getLargeur() * this.taille, puits.getProfondeur() * this.taille);
		setPreferredSize(dimension);
		setBackground(Color.white);
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		Dimension dimension = new Dimension(puits.getLargeur() * this.taille, puits.getProfondeur() * this.taille);
		setPreferredSize(dimension);
		setBackground(Color.white);
	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	private void setVuePieceFantome(VuePieceFantome vuePieceFantome) {
		this.vuePieceFantome = vuePieceFantome;
	}

	public VueTas getVueTas() {
		return vueTas;
	}

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent event) {
		for (int i = 0; i < puits.getProfondeur(); i++) {
			if (this.puits.ligneEstCompletee(i)) {
				this.puits.supprimerLigne(i);
				this.puits.ajouterScore(10);
				if(this.puits.getScore()%100==0){
					if(this.puits.getNiveau()<5){
						this.puits.augmenterNiveau();
						this.gravite.setPeriodicite(this.gravite.getPeriodicite()-150);
					}
				}
			}
		}
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			Piece piece = (Piece) event.getNewValue();
			if (piece != null) {
				this.setVuePiece(new VuePiece(piece, this.taille));
				this.setVuePieceFantome(new VuePieceFantome(piece, this.taille));
				piece.setPuits(puits);
			} else {
				this.setVuePiece(new VuePiece(null, this.taille));
				this.setVuePieceFantome(new VuePieceFantome(null, this.taille));
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();
		creationGrille(g2D);
		if (this.vuePiece != null) {
			this.vuePiece.afficherPiece(g2D);
		}
		if (this.vuePieceFantome != null) {
			this.vuePieceFantome.afficherPieceFantome(g2D);
		}
		
		if (this.vueTas != null) {
			this.vueTas.afficher(g2D);
		}
		g2D.dispose();
	}

	protected void creationGrille(Graphics2D g2D) {
		g2D.setColor(java.awt.Color.LIGHT_GRAY);
		for (int i = 0; i < puits.getLargeur() * this.taille; i += this.taille) {
			for (int y = 0; y < puits.getProfondeur() * this.taille; y += this.taille) {
				g2D.drawRect(i, y, taille, taille);
			}
		}
	}

	public void setGravite(Gravite gravite) {
		this.gravite = gravite;
	}

	public Gravite getGravite() {
		return this.gravite;
	}
}
