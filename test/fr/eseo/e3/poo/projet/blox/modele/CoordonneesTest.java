package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordonneesTest {
	@Test
	void testConstructeur() {
		Coordonnees coos = new Coordonnees(2, 2);
		assertEquals(2, coos.getAbscisse(), "Abscisse");
		assertEquals(2, coos.getOrdonnee(), "Ordonnee");
	}

	@Test
	void testToString() {
		Coordonnees coos = new Coordonnees(4, 2);
		assertEquals("(4, 2)", coos.toString(), "Test to string");
	}

	@Test
	void testSetters() {
		Coordonnees coos = new Coordonnees(4, 2);
		coos.setAbscisse(0);
		coos.setOrdonnee(0);
		assertEquals(0, coos.getAbscisse(), "L'abscisse n'est pas la bonne");
		assertEquals(0, coos.getOrdonnee(), "L'ordonnee n'est pas la bonne");
	}

	@Test
	void testHashcode() {
		Coordonnees coos = new Coordonnees(1, 1);
		int hashcodeAtt = coos.hashCode();
		assertEquals(hashcodeAtt, coos.hashCode(), "Test du hashcode");
	}

	@Test
	public void testEquals() {
		Coordonnees coos1 = new Coordonnees(1, 2);
		Coordonnees coos2 = new Coordonnees(1, 2);
		Coordonnees coos3 = new Coordonnees(2, 2);
		Coordonnees coos4 = new Coordonnees(1, 3);
		Coordonnees coos5 = null;
		Object o = new Object();

		assertTrue("L'objet doit être égal à lui-même", coos1.equals(coos2));
		assertTrue("Deux objets égaux doivent être égaux dans les deux sens", coos2.equals(coos2));
		assertFalse("Deux objets différents ne doivent pas être égaux", coos1.equals(coos3));
		assertFalse("Deux objets avec des abscisses différentes ne doivent pas être égaux", coos1.equals(coos4));
		assertFalse("Un objet ne doit pas être égal à null", coos1.equals(coos5));
		assertFalse("Un objet de type différent ne doit pas être égal", coos1.equals(o));
	}
}