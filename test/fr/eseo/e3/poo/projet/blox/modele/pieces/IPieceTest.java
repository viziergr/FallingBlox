package fr.eseo.e3.poo.projet.blox.modele.pieces;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPieceTest {
	@Test
	void testConstructeur() {
		IPiece iP = new IPiece(new Coordonnees(1,1),Couleur.BLEU);
		List<Element> testElements = new ArrayList<Element>();
		testElements.add(new Element(1,1,Couleur.BLEU));
		testElements.add(new Element(1,2,Couleur.BLEU));
		testElements.add(new Element(1,0,Couleur.BLEU));
		testElements.add(new Element(1,-1,Couleur.BLEU));
		assertEquals(testElements,iP.getElements(),"Elements");
	}
	
	@Test
	void testToString() {
		IPiece iP = new IPiece(new Coordonnees(1,1),Couleur.CYAN);
		String ret = "IPiece :\n"
				+ "\t(1, 1) - CYAN\n"
				+ "\t(1, 2) - CYAN\n"
				+ "\t(1, 0) - CYAN\n"
				+ "\t(1, -1) - CYAN\n";
		assertEquals(ret,iP.toString(),"La chaine n'est pas la bonne");
	}
	
	@Test
	void testGetType() {
		Piece iPiece = new IPiece(new Coordonnees(1,1),Couleur.BLEU);
		assertEquals("I",iPiece.getType(),"Le type n'est pas le bon");
	}
}