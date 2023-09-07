package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Puits puits;
    private VuePiece vuePiece;
    private int taille = 10;

    public PanneauInformation(Puits puits) {
        this.puits = puits;
        this.vuePiece = new VuePiece(puits.getPieceSuivante(), taille);
        this.puits.addPropertyChangeListener(this);
        Dimension dimension = new Dimension(70, 70);
        setPreferredSize(dimension);
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            Piece piece = (Piece) e.getNewValue();
            if (piece != null) {
                this.setVuePiece(new VuePiece(piece, taille));
                piece.setPuits(puits);
            } else {
                this.setVuePiece(new VuePiece(null, taille));
            }
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.vuePiece != null) {
            this.vuePiece.afficherPiece((Graphics2D) g);
        }
        g.setColor(java.awt.Color.BLACK);
        g.drawString("Score: " + this.puits.getScore(), 5, 70);
    }
}