package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.awt.Graphics2D;
import java.awt.Color;

public class VuePieceFantome {
    private final int taille;
    private final Piece piece;

    public VuePieceFantome(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public void afficherPieceFantome(Graphics2D g2d) {
        if (this.piece.getElements() != null) {
            Piece ret = this.piece.getPuits().clone();
            ret.setPosition(ret.getElements().get(0).getCoordonnees().getAbscisse(), 1);
            //ret.descenteDirecte();
            for (Element e : ret.getElements()) {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(e.getCoordonnees().getAbscisse(), e.getCoordonnees().getOrdonnee(), this.taille,
                        this.taille);
            }
        }
    }
}
