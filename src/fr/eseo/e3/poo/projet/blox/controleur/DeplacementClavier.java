package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class DeplacementClavier implements KeyListener {
	private VuePuits vuePuits;
	private Puits puits;

	public DeplacementClavier(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		try {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				this.puits.getPieceActuelle().deplacerDe(-1, 0);
				break;
			case KeyEvent.VK_D:
				this.puits.getPieceActuelle().deplacerDe(1, 0);
				break;
			case KeyEvent.VK_S:
				this.puits.gravite();
				break;
			case KeyEvent.VK_M:
				this.puits.getPieceActuelle().tourner(false);
				break;
			case KeyEvent.VK_SPACE:
				this.puits.getPieceActuelle().descenteDirecte();
				break;
			default:
				this.puits.inversePiece();
				break;
			}
		} catch (Exception exception) {
		}
		this.vuePuits.repaint();
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
	}
}
