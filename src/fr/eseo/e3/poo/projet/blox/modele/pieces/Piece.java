package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	private List<Element> elements;
	private Puits puits;

	public Piece(Coordonnees coordonnees, Couleur couleur) {
		elements = new ArrayList<Element>();
		this.setElements(coordonnees, couleur);
	}

	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	public abstract String getType();

	public List<Element> getElements() {
		return this.elements;
	}

	// SI PROBLEME IL FAUT MODIFIER CA CAR CA PEUT ENGENDRER DES PROBLEMES DE RAM
	// PEUT ETRE
	public void setPosition(int abscisse, int ordonnee) {
		this.setElements(new Coordonnees(abscisse, ordonnee), this.elements.get(0).getCouleur());
	}

	public Puits getPuits() {
		return puits;
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public void tourner(boolean sensHoraire) throws BloxException {
		List<Element> elementsTemp = new ArrayList<>();
		if (this.puits != null) {
			for (Element i : this.elements) {
				Coordonnees coordTemp = effectuerRotationTemporaire(i.getCoordonnees(), sensHoraire);
				elementsTemp.add(new Element(coordTemp, i.getCouleur()));
			}
			for (Element i : elementsTemp) {
				verifierSortiePuits(i, 0, 0);
				verifierCollision(i, 0, 0);
			}
		}
		effectuerRotation(sensHoraire);
	}

	private Coordonnees effectuerRotationTemporaire(Coordonnees coord, boolean sensHoraire) {
		int x = this.elements.get(0).getCoordonnees().getAbscisse();
		int y = this.elements.get(0).getCoordonnees().getOrdonnee();
		int nouvX = coord.getAbscisse() - x;
		int nouvY = coord.getOrdonnee() - y;

		if (sensHoraire) {
			return new Coordonnees(-nouvY + x, nouvX + y);
		} else {
			return new Coordonnees(nouvY + x, -nouvX + y);
		}
	}

	private void effectuerRotation(boolean sensHoraire) {
		int x = this.elements.get(0).getCoordonnees().getAbscisse();
		int y = this.elements.get(0).getCoordonnees().getOrdonnee();
		for (Element i : this.elements) {
			i.deplacerDe(-x, -y);
			if (sensHoraire) {
				i.setCoordonnees(new Coordonnees(-i.getCoordonnees().getOrdonnee(), i.getCoordonnees().getAbscisse()));
			} else {
				i.setCoordonnees(new Coordonnees(i.getCoordonnees().getOrdonnee(), -i.getCoordonnees().getAbscisse()));
			}
			i.deplacerDe(x, y);
		}
	}

	public String toString() {
		String ret = getClass().getSimpleName() + ":\n";
		for (int i = 0; i < elements.size(); i++) {
			ret += "\t" + elements.get(i).toString() + "\n";
		}
		return ret;
	}

	public void deplacerDe(int x, int y) throws BloxException {
		verifierDeplacement(x, y);
		if (this.puits != null) {
			for (Element i : this.elements) {
				verifierSortiePuits(i, x, y);
				if (i.getCoordonnees().getOrdonnee() >= 0) {
					verifierCollision(i, x, y);
				}
			}
		}
		deplacerElements(x, y);
	}

	private void deplacerElements(int x, int y) {
		for (Element i : this.elements) {
			i.deplacerDe(x, y);
		}
	}

	private void verifierDeplacement(int x, int y) {
		if (y < 0 || y > 1 || x > 1 || x < -1) {
			throw new IllegalArgumentException("Mauvais déplacement");
		}
	}

	private void verifierSortiePuits(Element i, int x, int y) throws BloxException {
		if (i.getCoordonnees().getAbscisse() + x < 0
				|| i.getCoordonnees().getAbscisse() + x >= this.puits.getLargeur()) {
			throw new BloxException("Sortie", BloxException.BLOX_SORTIE_PUITS);
		}
	}

	private void verifierCollision(Element i, int x, int y) throws BloxException {
		if (i.getCoordonnees().getOrdonnee() + y >= this.puits.getProfondeur()) {
			throw new BloxException("Collision", BloxException.BLOX_COLLISION);
		}
		if (this.puits.getTas().getElements()[i.getCoordonnees().getOrdonnee() + y][i.getCoordonnees().getAbscisse()
				+ x] != null) {
			throw new BloxException("Collision", BloxException.BLOX_COLLISION);
		}
	}

	public boolean peutDescendre() {
		for (Element i : this.elements) {
			try{
				verifierCollision(i, 0, 1);
			}
			catch(BloxException e){
				return false;
			}
		}
		return true;
	}

	public void descenteDirecte(){
		while(peutDescendre()){
			this.getPuits().gravite();
		}
	}
	
	public Couleur getCouleur() {
		return this.getElements().get(0).getCouleur();
	}
}