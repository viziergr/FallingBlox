package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {
	private VuePuits vuePuits;
	private Puits puits;

	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}

	public void mouseClicked(MouseEvent event) {
		try {
			if (this.puits.getPieceActuelle() != null) {
				if (SwingUtilities.isLeftMouseButton(event)) {

					this.puits.getPieceActuelle().tourner(false);
				} else if (SwingUtilities.isMiddleMouseButton(event)) {

					this.puits.getPieceActuelle().tourner(true);
				}
				// Si le bouton du milieu de la souris est cliqué, inverse la piece actuelle et
				// la piece suivante
				else if (SwingUtilities.isRightMouseButton(event)) {
					this.puits.getPieceActuelle().tourner(true);

				}

				else {
					throw new IllegalArgumentException("Le bouton de la souris n'est pas reconnu");
				}
			}
		} catch (Exception e) {

		}
		this.vuePuits.repaint();
	}
}
