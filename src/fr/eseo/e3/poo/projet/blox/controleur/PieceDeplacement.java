package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;

public class PieceDeplacement extends MouseAdapter {

    private VuePuits vuePuits;
    private Puits puits;
    private int colonne = -1;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (this.puits.getPieceActuelle() == null) {
            return;
        }
        int souris = (int) (event.getX() / this.vuePuits.getTaille());

        if (this.colonne == -1) {
            this.colonne = souris;
        } else {
            if (souris != colonne) {
                try {
                    if (souris > this.colonne) {
                        this.puits.getPieceActuelle().deplacerDe(1, 0);
                    } else {
                        this.puits.getPieceActuelle().deplacerDe(-1, 0);
                    }
                    this.colonne = souris;
                } catch (Exception e) {
                }
            }
        }
        this.vuePuits.repaint();
    }

    public void mouseDragged(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
        this.colonne = -1;
    }

    public void mouseWheelMoved(MouseWheelEvent event) {
        if (this.puits.getPieceActuelle() != null) {
            if (event.getWheelRotation() > 0) {
                try {
                    this.puits.gravite();
                } catch (Exception e) {
                }
            }
        }
        this.vuePuits.repaint();
    }
}
