import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zoo {
	private static final Logger logger = LogManager.getLogger(Zoo.class);
	public int visiteurs;
	public List<Secteur> secteursAnimaux = new ArrayList<Secteur>();
	
	
	public void ajouterSecteur(String s) {
		logger.info("Creation secteur : "+s);
		Secteur secteur = new Secteur(s);
		secteursAnimaux.add(secteur);
	}
	
	public void nouveauVisiteur() throws LimiteVisiteurException{
		logger.info("Ajout Visiteur");
		visiteurs++;
		if(visiteurs > this.getLimiteVisiteur()) {
			logger.fatal("Limite de visiteur dépassée");
			throw new LimiteVisiteurException("LimiteVisiteurException");
		}
	}
	
	public int getLimiteVisiteur() {
		return secteursAnimaux.size() * 15;
	}
	
	public void nouvelAnimal(Animal a) throws AnimalDansMauvaisSecteurException {
		logger.info("Nouvel Animal");
		for(Secteur sec : secteursAnimaux) {
			if((a.getTypeAnimal()).equals(sec.obtenirType())) {
				sec.ajouterAnimal(a);
				return;
			}
		}
		logger.error("Aucun secteur correspondant à ce type d'animal");
		throw new AnimalDansMauvaisSecteurException("AnimalDansMauvaisSecteurException");
	}
	
	public int nombreAnimaux() {
		int taille = 0;
		for(Secteur sec : secteursAnimaux) {
			taille+= sec.getNombreAnimaux();
		}
		logger.debug("Nombre d'animaux"+taille);
		return taille;
	}
	
	public Secteur PlusGrosSecteur() {
		logger.info("Plus gros secteur");
		if(this.secteursAnimaux.size() ==1) {
			logger.warn("Il n'y a qu'un seul secteur");
		}
		SecteurSizeComparator SecteurComp = new SecteurSizeComparator();
		Collections.sort(this.secteursAnimaux, SecteurComp);
		return this.secteursAnimaux.get(this.secteursAnimaux.size()-1);
	}
}
