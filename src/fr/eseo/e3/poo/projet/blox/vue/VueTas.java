package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
    public static final double MULTIPLIER_NUANCE = 0.44;

    private final VuePuits vuePuits;
    private final Tas tas;

    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.tas = this.vuePuits.getPuits().getTas();
    }

    public Color nuance(Color couleur) {
        int rouge = (int) (couleur.getRed() * (1 - MULTIPLIER_NUANCE));
        int vert = (int) (couleur.getGreen() * (1 - MULTIPLIER_NUANCE));
        int bleu = (int) (couleur.getBlue() * (1 - MULTIPLIER_NUANCE));
        return new Color(rouge, vert, bleu);
    }

    //Méthode qui crée les éléments du tas dans la fenetre du puits
    public void afficher(Graphics2D g2d) {
        for (int i = 0; i < this.tas.getElements().length; i++) {
            for (int j = 0; j < this.tas.getElements()[i].length; j++) {
                if (this.tas.getElements()[i][j] != null) {
                    g2d.setColor(nuance(this.tas.getElements()[i][j].getCouleur().getCouleurPourAffichage()));
                    g2d.fill3DRect(j * this.vuePuits.getTaille(), i * this.vuePuits.getTaille(),
                            this.vuePuits.getTaille(), this.vuePuits.getTaille(),true);
                }
            }
        }
    }
    
    public VuePuits getVuePuits() {
        return vuePuits;
    }

    public Tas getTas() {
        return this.tas;
    }
}
