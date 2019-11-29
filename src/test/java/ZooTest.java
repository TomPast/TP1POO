import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZooTest {
	private static final Logger logger = LogManager.getLogger(ZooTest.class);
	
	@Test
	public void testNouveauVisiteur() throws LimiteVisiteurException {
		logger.debug("testNouveauVisiteur");
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
		logger.debug("testNouvelAnimal");
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
	
	@Test
	public void testPlusGrosSecteur() throws AnimalDansMauvaisSecteurException {
		logger.debug("testPlusGrosSecteur");
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Canin");
		zoo.ajouterSecteur("Félin");
		Chat chat = new Chat();
		Chien chien = new Chien();
		zoo.nouvelAnimal(chat);
		zoo.nouvelAnimal(chien);
		zoo.nouvelAnimal(chien);
		
		assertEquals(zoo.PlusGrosSecteur().obtenirType(),"Canin");
	}


}
