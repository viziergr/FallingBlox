package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PuitsTest {
	@Test
	void testConstructeur0() {
		Puits p1 = new Puits();
		assertEquals(10, p1.getLargeur(), "La largeur n'est pas celle par défaut");
		assertEquals(20, p1.getProfondeur(), "La hauteur n'est pas celle par défaut");
	}

	@Test
	void testConstructeur1() {
		Puits p1 = new Puits(15, 25);
		assertEquals(15, p1.getLargeur(), "La largeur n'est pas celle par défaut");
		assertEquals(25, p1.getProfondeur(), "La hauteur n'est pas celle par défaut");
	}

	@Test
	void testConstructeur2() {
		Puits p1 = new Puits(15,25,10,3);
		assertEquals(15,p1.getLargeur());
		assertEquals(25,p1.getProfondeur());
	}
	@Test
	void testGetSetPieceAct() {
		Puits p1 = new Puits();
		p1.setPieceActuelle(new OPiece(new Coordonnees(1, 1), Couleur.JAUNE));
		assertEquals(new OPiece(new Coordonnees(1, 1), Couleur.JAUNE).toString(), p1.getPieceActuelle().toString(),
				"La piece actuelle n'est pas la bonne");
	}

	@Test
	void testGetSetPieceSuiv0() {
		Puits p1 = new Puits();
		p1.setPieceSuivante(new OPiece(new Coordonnees(1, 1), Couleur.JAUNE));
		assertEquals(new OPiece(new Coordonnees(1, 1), Couleur.JAUNE).toString(), p1.getPieceSuivante().toString(),
				"La piece actuelle n'est pas la bonne");
	}

	@Test
	void testGetSetPieceSuiv1() {
		Puits p1 = new Puits();
		OPiece oPiece1 = new OPiece(new Coordonnees(1, 1), Couleur.JAUNE);
		OPiece oPiece2 = new OPiece(new Coordonnees(2, 2), Couleur.BLEU);
		p1.setPieceSuivante(oPiece1);
		assertEquals(oPiece1.toString(), p1.getPieceSuivante().toString(), "La piece actuelle n'est pas la bonne");
		p1.setPieceSuivante(oPiece2);
		assertEquals(oPiece2.toString(), p1.getPieceSuivante().toString(), "La piece actuelle n'est pas la bonne");
	}

	@Test
	void testGetSetProfondeur() {
		Puits p1 = new Puits();
		assertEquals(10, p1.getLargeur(), "La largeur n'est pas celle par défaut");
		assertEquals(20, p1.getProfondeur(), "La hauteur n'est pas celle par défaut");

		p1.setLargeur(15);
		p1.setProfondeur(15);

		assertEquals(15, p1.getLargeur(), "La largeur n'a pas été modifiée");
		assertEquals(15, p1.getProfondeur(), "La profondeur n'a pas été modifiée");
	}

	@Test
	void testtoString0() {
		Puits p1 = new Puits(10, 15);
		String ret = "Puits : Dimension 10 x 15\n" + "Piece Actuelle : <aucune>\n" + "Piece Suivante : IPiece :\n"
				+ "\t(7, 8) - ROUGE\n" + "\t(7, 9) - ROUGE\n" + "\t(7, 7) - ROUGE\n" + "\t(7, 6) - ROUGE\n";
		p1.setPieceSuivante(new IPiece(new Coordonnees(7, 8), Couleur.ROUGE));
		assertEquals(ret, p1.toString(), "Les toString sont différents");
	}

	@Test
	void testtoString1() {
		Puits p1 = new Puits(10, 15);
		p1.setPieceActuelle(new IPiece(new Coordonnees(7, 8), Couleur.ROUGE));
		String ret = "Puits : Dimension 10 x 15\n" + "Piece Actuelle : IPiece :\n" + "\t(7, 8) - ROUGE\n"
				+ "\t(7, 9) - ROUGE\n" + "\t(7, 7) - ROUGE\n" + "\t(7, 6) - ROUGE\n" + "Piece Suivante : IPiece :\n"
				+ "\t(7, 8) - ROUGE\n" + "\t(7, 9) - ROUGE\n" + "\t(7, 7) - ROUGE\n" + "\t(7, 6) - ROUGE\n";
		p1.setPieceSuivante(new IPiece(new Coordonnees(7, 8), Couleur.ROUGE));
		assertEquals(ret, p1.toString(), "Les toString sont différents");
	}

	@Test
	void testtoString2() {
		Puits p1 = new Puits(10, 15);
		String ret = "Puits : Dimension 10 x 15\n" + "Piece Actuelle : <aucune>\n" + "Piece Suivante : <aucune>\n";
		assertEquals(ret, p1.toString(), "Les toString sont différents");
	}
	
	@Test
	void testPuitsAvecException() {
		IllegalArgumentException exceptionL3P16 = assertThrows(IllegalArgumentException.class, () -> {
			new Puits(3, 16);
		});

		String expectedMessage = "La largeur doit etre entre 5 et 15 et la hauteur entre 15 et 25";
		String actualMessageL3P16 = exceptionL3P16.getMessage();
		assertTrue(actualMessageL3P16.contains(expectedMessage),"Le message obtenu ne contient pas le message attendu");

		IllegalArgumentException exceptionL16P16 = assertThrows(IllegalArgumentException.class, () -> {
			new Puits(16, 16);
		});
		String actualMessageL16P16 = exceptionL16P16.getMessage();
		assertTrue(actualMessageL16P16.contains(expectedMessage),"Le message obtenu ne contient pas le message attendu");

		IllegalArgumentException exceptionL10P5 = assertThrows(IllegalArgumentException.class, () -> {
			new Puits(10, 5);
		});
		String actualMessageL10P5 = exceptionL10P5.getMessage();
		assertTrue(actualMessageL10P5.contains(expectedMessage),"Le message obtenu ne contient pas le message attendu");
		
		IllegalArgumentException exceptionL10P35 = assertThrows(IllegalArgumentException.class, () -> {
			new Puits(10, 35);
		});
		String actualMessageL10P35 = exceptionL10P35.getMessage();
		assertTrue(actualMessageL10P35.contains(expectedMessage),"Le message obtenu ne contient pas le message attendu");
	}
	
	@Test
	void testSetLargeurProfondeur() {
		Puits p1 = new Puits(15,25);
		assertEquals(15,p1.getLargeur(),"La largeur n'est pas la bonne");
		assertEquals(25,p1.getProfondeur(),"La profondeur n'est pas la bonne");
		
		IllegalArgumentException exceptionL4 = assertThrows(IllegalArgumentException.class, () -> {
			p1.setLargeur(4);
		});
		String expectedMessageL4 = "La largeur doit etre entre 5 et 15 et la hauteur entre 15 et 25";
		String actualMessageL4 = exceptionL4.getMessage();
		assertTrue(actualMessageL4.contains(expectedMessageL4),"Le message obtenu ne contient pas le message attendu");
		
		IllegalArgumentException exceptionL16 = assertThrows(IllegalArgumentException.class, () -> {
			p1.setLargeur(16);
		});
		String expectedMessageL16 = "La largeur doit etre entre 5 et 15 et la hauteur entre 15 et 25";
		String actualMessageL16 = exceptionL16.getMessage();
		assertTrue(actualMessageL16.contains(expectedMessageL16),"Le message obtenu ne contient pas le message attendu");
		
		IllegalArgumentException exceptionP4 = assertThrows(IllegalArgumentException.class, () -> {
			p1.setProfondeur(4);
		});
		String expectedMessageP4 = "La largeur doit etre entre 5 et 15 et la hauteur entre 15 et 25";
		String actualMessageP4 = exceptionP4.getMessage();
		assertTrue(actualMessageP4.contains(expectedMessageP4),"Le message obtenu ne contient pas le message attendu");
		
		IllegalArgumentException exceptionP36 = assertThrows(IllegalArgumentException.class, () -> {
			p1.setProfondeur(36);
		});
		String expectedMessageP36 = "La largeur doit etre entre 5 et 15 et la hauteur entre 15 et 25";
		String actualMessageP36 = exceptionP36.getMessage();
		assertTrue(actualMessageP36.contains(expectedMessageP36),"Le message obtenu ne contient pas le message attendu");
	}
	
	@Test
	void testSetGetTas() {
		Puits p1 = new Puits(15,25);
		Tas tas = new Tas(p1);
		p1.setTas(tas);
		assertEquals(tas,p1.getTas(),"Le tas n'est pas le bon");
		
		Puits p2 = new Puits(15,25);
		p2.setTas(tas);
		
		assertNotNull(p2.getTas(),"p2 n'a pas de tas");
	}
	
	@Test
    void testAddPropertyChangeListener() {
        // arrange
        Puits puits = new Puits(10, 20);
        PropertyChangeListener listener = evt -> {
            // ne rien faire ici
        };

        // act
        puits.addPropertyChangeListener(listener);

        // assert
        PropertyChangeSupport pcs = puits.getPcs();
        PropertyChangeListener[] listeners = pcs.getPropertyChangeListeners();
        assertEquals(1, listeners.length,"Il n'y a pas le bon nombre de listeners");
        assertEquals(listener, listeners[0],"Le listener[0] n'est pas le bon");
    }
	
	@Test
    void testRemovePropertyChangeListener() {
        // arrange
        Puits puits = new Puits(10, 20);
        PropertyChangeListener listener = evt -> {
            // ne rien faire ici
        };
        puits.addPropertyChangeListener(listener);

        // act
        puits.removePropertyChangeListener(listener);

        // assert
        PropertyChangeSupport pcs = puits.getPcs();
        PropertyChangeListener[] listeners = pcs.getPropertyChangeListeners();
        assertEquals(0, listeners.length,"Il n'y a pas le bon nombre de listeners");
    }
	
	@Test
	void testGravite() {
		Puits p1 = new Puits(15,25);
		IllegalArgumentException exp = assertThrows(IllegalArgumentException.class, () -> {
			p1.gravite();
		});
		String expectedMessage = "Il n'y a pas de PieceActuelle";
		String actualMessage = exp.getMessage();
		assertTrue(actualMessage.contains(expectedMessage),"Le message attendu est bien dans le message obtenu");
		
		p1.setPieceActuelle(new OPiece(new Coordonnees(4,4),Couleur.ROUGE));
		p1.gravite();
		assertEquals(4,p1.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse(),"L'abscisse a bougé");
		assertEquals(5,p1.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee(),"L'ordonnee n'a pas bougé");
	}
	
	@Test
	void testSetGetScoreNiveau() {
		Puits p1 = new Puits();
		assertEquals(0,p1.getScore(),"Le score de base n'est pas à 0");
		p1.ajouterScore(100);
		assertEquals(100,p1.getScore(),"Le score n'a pas été ajouté correctement");
		assertEquals(0, p1.getNiveau(),"Le nivveau de base n'est pas 0");
		p1.augmenterNiveau();
		assertEquals(1,p1.getNiveau(),"Le niveau n'a pas été augmenté");
	}
	
	@Test
	void testClonePiece() {
		Puits p1 = new Puits();
		Coordonnees coos = new Coordonnees(1,1);
		Couleur couleur = Couleur.BLEU;
		Piece o = new OPiece(coos,couleur);
		Piece i = new IPiece(coos,couleur);
		Piece j = new JPiece(coos,couleur);
		Piece l = new LPiece(coos,couleur);
		Piece t = new TPiece(coos,couleur);
		Piece z = new ZPiece(coos,couleur);
		Piece s = new SPiece(coos,couleur);
		
		p1.setPieceActuelle(o);
		Piece obis = p1.clone();
		
		p1.setPieceActuelle(i);
		Piece ibis = p1.clone();
		
		p1.setPieceActuelle(j);
		Piece jbis = p1.clone();
		
		p1.setPieceActuelle(l);
		Piece lbis = p1.clone();
		
		p1.setPieceActuelle(t);
		Piece tbis = p1.clone();
		
		p1.setPieceActuelle(z);
		Piece zbis = p1.clone();
		
		p1.setPieceActuelle(s);
		Piece sbis = p1.clone();

		assertEquals(couleur,obis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,obis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,ibis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,ibis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,jbis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,jbis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,lbis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,lbis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,tbis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,tbis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,zbis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,zbis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
		
		assertEquals(couleur,sbis.getElements().get(0).getCouleur(),"La couleur n'est pas la bonne");
		assertEquals(coos,sbis.getElements().get(0).getCoordonnees(),"Les coordonnees ne sont pas les bonnes");
	}
	
	@Test
	void testGererCollision() {
		Puits p1 = new Puits();
		Piece o = new OPiece(new Coordonnees(1,1),Couleur.BLEU);
		p1.setPieceSuivante(o);
		assertNull(p1.getTas(),"le tas est vide");
		
	}
}
