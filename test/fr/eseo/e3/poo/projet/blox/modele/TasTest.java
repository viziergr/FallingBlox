package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TasTest {

	@Test
	public void testTasConstructeur2() {
		Puits p1 = new Puits(10,20);
		Tas tas = new Tas(p1,10);
		int compteur=0;
        for (int i=0; i<p1.getProfondeur(); i++) {
            for (int j=0; j<p1.getLargeur(); j++) {
                if (tas.getElements()[i][j] != null) {
                    System.err.println(tas.getElements()[i][j]);
                    compteur++;
                }
            }
        }
        assertEquals(10, compteur,"Le nombre d'éléments du tas n'est pas correct");
        System.err.println("-----------------------");
	}
    @Test
    public void testTasConstructeur3() {
        Puits p1 = new Puits(10,20);
        Tas tas = new Tas(p1, 10, 5);
        int compteur=0;
        for (int i=0; i<p1.getProfondeur(); i++) {
            for (int j=0; j<p1.getLargeur(); j++) {
                if (tas.getElements()[i][j] != null) {
                    System.err.println(tas.getElements()[i][j]);
                    compteur++;
                }
            }
        }
        assertEquals(10, compteur,"Le nombre d'éléments du tas n'est pas correct");
    }

    
}