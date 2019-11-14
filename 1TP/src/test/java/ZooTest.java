import static org.junit.Assert.*;

import org.junit.Test;

public class ZooTest {

	@Test
	public void testNouveauVisiteur() throws LimiteVisiteurException {
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Canin");
		for(int i=0; i<zoo.getLimiteVisiteur();i++) {
			zoo.nouveauVisiteur();
		}
		try {
			zoo.nouveauVisiteur();
			fail("Exception non lancée");
		}catch(LimiteVisiteurException e) {
			assertEquals(e.getMessage(), "LimiteVisiteurException", e.getMessage());
		}
	}

	@Test
	public void testNouvelAnimal() {
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Canin");
		Chat chat = new Chat();
		try {
			zoo.nouvelAnimal(chat);
			fail();
		}catch(AnimalDansMauvaisSecteurException e) {
			assertEquals("Pas le bon message", "AnimalDansMauvaisSecteurException", e.getMessage());
		}

	}


}
