package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
    private Element[][] elements;
    private Puits puits;

    public Tas(Puits puits, int nbElements, int nbLignes) {
        if (nbElements > puits.getLargeur() * puits.getProfondeur() || nbElements < 0 || nbLignes < 0
                || nbLignes > puits.getProfondeur()) {
            throw new IllegalArgumentException("Le nombre d'éléments est trop grand");
        } else {
            this.puits = puits;
            this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
            java.util.Random rand = new java.util.Random();
            construireTas(nbElements, nbLignes, rand);
        }
    }

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
    }

    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, nbElements / puits.getLargeur() + 1);
    }

    public Puits getPuits() {
        return this.puits;
    }

    public Element[][] getElements() {
        return this.elements;
    }

    private void construireTas(int nbElements, int nbLignes, java.util.Random rand) {
        int ordon, absci, indiceCouleur;
        this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
        if ((nbElements != 0) & nbElements >= (this.puits.getLargeur() * nbLignes)) {
            throw new IllegalArgumentException("Le nombre d'éléments est trop grand");
        } else {
            int nombreElements = 0;
            while (nombreElements != nbElements) {
                ordon = this.puits.getProfondeur() - (rand.nextInt(nbLignes) + 1);
                absci = rand.nextInt(this.puits.getLargeur());
                if (this.elements[ordon][absci] == null) {
                    indiceCouleur = rand.nextInt(Couleur.values().length);
                    this.elements[ordon][absci] = new Element(absci, ordon, Couleur.values()[indiceCouleur]);
                    nombreElements++;
                }
            }
        }
    }

    // Méthode qui ajoute les éléments de la pièce au tas
    public void ajouterElements(Piece piece) {
        for (int i = 0; i < piece.getElements().size(); i++) {
            this.elements[piece.getElements().get(i).getCoordonnees().getOrdonnee()][piece.getElements().get(i)
                    .getCoordonnees().getAbscisse()] = piece.getElements().get(i);
        }
    }
}
