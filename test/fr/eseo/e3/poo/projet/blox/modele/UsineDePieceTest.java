package fr.eseo.e3.poo.projet.blox.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class UsineDePieceTest {
	@BeforeEach
	public void setUp() {
		// On remet le mode de génération des pièces à aléatoire complet avant chaque
		// test
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
	}

	@Test
	public void testGenererPiece() {
		Piece piece = UsineDePiece.genererPiece();

		// On vérifie que la pièce retournée n'est pas nulle
		assertNotNull(piece);

		// On vérifie que la couleur de la pièce est bien une couleur valide
		assertTrue(piece.getCouleur() instanceof Couleur);
	}

	@Test
	public void testSetMode() {
		// On change le mode de génération des pièces à aléatoire pièce
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);

		// On vérifie que le mode a bien été changé
		assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.getMode());
	}

	@Test
	public void testAleatoireComplet() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		for (int i = 0; i < 350; i++) {
			Piece piece = UsineDePiece.genererPiece();

			// On vérifie que la pièce retournée n'est pas nulle
			assertNotNull(piece);
		}
	}

	@Test
	public void testAleatoirePiece() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
		for (int i = 0; i < 15; i++) {
			Piece piece = UsineDePiece.genererPiece();

			// On vérifie que la pièce retournée n'est pas nulle
			assertNotNull(piece);
		}
	}

	@Test
	public void testCyclic() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		for (int i = 0; i < 7; i++) {
			Piece piece = UsineDePiece.genererPiece();
			assertNotNull(piece);
		}
	}
}