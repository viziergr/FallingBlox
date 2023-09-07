package fr.eseo.e3.poo.projet.blox.modele.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPieceTest {
	private OPiece oPiece;

	@Test
	void testConstructeur() {
		OPiece oP = new OPiece(new Coordonnees(1, 1), Couleur.BLEU);
		List<Element> testElements = new ArrayList<Element>();
		testElements.add(new Element(1, 1, Couleur.BLEU));
		testElements.add(new Element(2, 1, Couleur.BLEU));
		testElements.add(new Element(1, 0, Couleur.BLEU));
		testElements.add(new Element(2, 0, Couleur.BLEU));
		assertEquals(testElements, oP.getElements(), "Elements");
	}

	@Test
	void testToString() {
		OPiece oP = new OPiece(new Coordonnees(1, 1), Couleur.CYAN);
		String ret = "OPiece :\n" + "\t(1, 1) - CYAN\n" + "\t(2, 1) - CYAN\n" + "\t(1, 0) - CYAN\n"
				+ "\t(2, 0) - CYAN\n";
		assertEquals(ret, oP.toString(), "La chaine n'est pas la bonne");
	}

	@BeforeEach
	public void setUp() throws Exception {
		Coordonnees coordonnees = new Coordonnees(5, 20);
		Couleur couleur = Couleur.BLEU;
		oPiece = new OPiece(coordonnees, couleur);
	}

	@Test
	public void testType() {
		assertEquals("O", oPiece.getType());
	}


	@Test
	public void testTourner() {
		oPiece.tourner(true);
		assertEquals(4, oPiece.getElements().size());
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(5, 21), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(6, 21), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(5, 11), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(6, 11), Couleur.BLEU)));
	}

	@Test
	public void testSetElements() {
		oPiece.setElements(new Coordonnees(3, 10), Couleur.ORANGE);
		assertEquals(4, oPiece.getElements().size());
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(5, 20), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(6, 20), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(5, 19), Couleur.BLEU)));
		assertFalse(oPiece.getElements().contains(new Element(new Coordonnees(6, 19), Couleur.BLEU)));
		assertEquals(new Element(new Coordonnees(3, 10), Couleur.ORANGE), oPiece.getElements().get(0));
		assertEquals(new Element(new Coordonnees(4, 10), Couleur.ORANGE), oPiece.getElements().get(1));
		assertEquals(new Element(new Coordonnees(3, 9), Couleur.ORANGE), oPiece.getElements().get(2));
		assertEquals(new Element(new Coordonnees(4, 9), Couleur.ORANGE), oPiece.getElements().get(3));
	}
}