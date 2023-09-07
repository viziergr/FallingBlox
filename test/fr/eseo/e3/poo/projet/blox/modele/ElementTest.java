package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementTest {
	@Test
	void testConstructeur1() {
		Element e1 = new Element(new Coordonnees(1,1));
		assertEquals(Couleur.ROUGE,e1.getCouleur(),"Couleur");
		assertEquals(new Coordonnees(1,1),e1.getCoordonnees(),"Coordonnees");
	}
	
	@Test
	void testConstructeur2() {
		Element e1 = new Element(1,1);
		assertEquals(Couleur.ROUGE,e1.getCouleur(),"Couleur");
		assertEquals(new Coordonnees(1,1),e1.getCoordonnees(),"Coordonnees");
	}
	
	@Test
	void testConstructeur3() {
		Element e1 = new Element(new Coordonnees(1,1),Couleur.BLEU);
		assertEquals(Couleur.BLEU,e1.getCouleur(),"Couleur");
		assertEquals(new Coordonnees(1,1),e1.getCoordonnees(),"Coordonnees");
	}
	
	@Test
	void testConstructeur4() {
		Element e1 = new Element(1,1,Couleur.BLEU);
		assertEquals(Couleur.BLEU,e1.getCouleur(),"Couleur");
		assertEquals(new Coordonnees(1,1),e1.getCoordonnees(),"Coordonnees");
	}
	
	@Test
	void testSetCoos() {
		Element e1 = new Element(1,1,Couleur.BLEU);
		e1.setCoordonnees(new Coordonnees(2,2));
		assertEquals(new Coordonnees(2,2),e1.getCoordonnees(),"test setCoordonnees");
	}
	
	@Test
	void testToString() {
		Element e1 = new Element(1,1);
		assertEquals("(1, 1) - ROUGE",e1.toString(),"Test du toString()");
	}
	
	@Test
	void testHashcode() {
		Element e1 = new Element(1,1);
		int hashcodeAtt = e1.hashCode();
		assertEquals(hashcodeAtt, e1.hashCode(),"Test du hashcode");
	}
	
	@Test
	void testEquals() {
		Coordonnees c1 = new Coordonnees(0, 0);
        Coordonnees c2 = new Coordonnees(1, 1);
        Couleur couleur1 = Couleur.ROUGE;
        Couleur couleur2 = Couleur.VERT;

        Element e1 = new Element(c1, couleur1);
        Element e2 = new Element(c1, couleur1);
        Element e3 = new Element(c2, couleur1);
        Element e4 = new Element(c1, couleur2);

        // Vérification que la méthode equals() renvoie true pour des objets identiques
        assertTrue(e1.equals(e1), "equals() ne renvoie pas true pour un objet identique");

        // Vérification que la méthode equals() renvoie true pour des objets égaux
        assertTrue(e1.equals(e2), "equals() ne renvoie pas true pour des objets égaux");

        // Vérification que la méthode equals() renvoie false pour des objets avec des coordonnées différentes
        assertFalse(e1.equals(e3), "equals() ne renvoie pas false pour des objets avec des coordonnées différentes");

        // Vérification que la méthode equals() renvoie false pour des objets avec des couleurs différentes
        assertFalse(e1.equals(e4), "equals() ne renvoie pas false pour des objets avec des couleurs différentes");

        // Vérification que la méthode equals() renvoie false pour un objet null
        assertFalse(e1.equals(null), "equals() ne renvoie pas false pour un objet null");
    
	}
	@Test
    public void testSetCouleur() {
        // Créer une instance de la classe à tester
        Element element = new Element(1, 2, Couleur.ROUGE);

        // Appeler la méthode setCouleur() avec une nouvelle couleur
        element.setCouleur(Couleur.BLEU);

        // Vérifier que la couleur a été correctement mise à jour
        assertEquals(Couleur.BLEU, element.getCouleur(), "La couleur de l'objet n'a pas été mise à jour correctement");
    }
	
	@Test
	public void testDeplacerDe() {
		Element element = new Element(1,2,Couleur.ROUGE);
		element.deplacerDe(1, 1);
		assertEquals(new Coordonnees(2,3), element.getCoordonnees(),"Les coordonnées ne sont pas les bonnes");
	}
	
	@Test
	public void testEquals2() {
		Element element = new Element(1,2,Couleur.ROUGE);
		String str = "chaine de caractères";
		assertFalse(element.equals(str),"Les deux éléments sont les mêmes");
	}
}
