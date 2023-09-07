package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPiece extends Piece {
	public static final String TYPE = "I";
	public IPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
	}
	
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		this.getElements().clear();
		getElements().add(new Element(coordonnees,couleur));
		getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee()+1,couleur));
		getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-1,couleur));
		getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-2,couleur));
	}
	public String toString() {
		String ret = "IPiece :\n";
		for(int i = 0;i<getElements().size();i++) {
			ret += "\t"+getElements().get(i).toString()+"\n";
		}
		return ret;
	}

	public String getType() {
		return TYPE;
	}
}
