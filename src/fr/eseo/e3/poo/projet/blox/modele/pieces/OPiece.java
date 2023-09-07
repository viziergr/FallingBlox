package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPiece extends Piece{
	public static final String TYPE = "O";
	public OPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees,couleur);
	}
	
	@Override
	public void tourner(boolean sensHoraire) {
		//rien a faire car une OPiece ne peut pas tourner
	}
	
	@Override
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		this.getElements().clear();
		getElements().add(new Element(coordonnees,couleur));
		getElements().add(new Element(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee(),couleur));
		getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-1,couleur));
		getElements().add(new Element(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee()-1,couleur));
	}
	
	@Override
	public String toString() {
		String ret = "OPiece :\n";
		for(int i = 0;i<getElements().size();i++) {
			ret += "\t"+getElements().get(i).toString()+"\n";
		}
		return ret;
	}
	public String getType() {
		return TYPE;
	}
}
