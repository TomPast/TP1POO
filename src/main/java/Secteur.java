import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Secteur {
	private String typeAnimauxDansSecteur;
	private List<Animal> animauxDansSecteur = new ArrayList<Animal>();
	
	private static final Logger logger = LogManager.getLogger(SecteurSizeComparator.class);
	
	public Secteur(String s) {
		typeAnimauxDansSecteur = s;
	}
	public void ajouterAnimal(Animal a) {
		logger.trace("Ajout Animal");
		animauxDansSecteur.add(a);
	}
	
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public String obtenirType() {
		return typeAnimauxDansSecteur;
	}
	
}
