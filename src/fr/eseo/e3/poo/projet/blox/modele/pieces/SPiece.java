package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class SPiece extends Piece{
    public static final String TYPE = "S";
    public SPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.getElements().clear();
        getElements().add(new Element(coordonnees, couleur));
        getElements().add(new Element(coordonnees.getAbscisse() - 1, coordonnees.getOrdonnee(), couleur));
        getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur));
        getElements().add(new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur));
    }

    public String toString() {
        String ret = "SPiece :\n";
        for (int i = 0; i < getElements().size(); i++) {
            ret += "\t" + getElements().get(i).toString() + "\n";
        }
        return ret;
    }
    public String getType() {
        return TYPE;
    }
}
