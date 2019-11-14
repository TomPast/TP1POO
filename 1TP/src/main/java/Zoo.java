import java.util.ArrayList;
import java.util.List;

public class Zoo {
	public int visiteurs;
	private List<Secteur> secteursAnimaux = new ArrayList<Secteur>();
	
	
	public void ajouterSecteur(String s) {
		Secteur secteur = new Secteur(s);
		secteursAnimaux.add(secteur);
	}
	
	public void nouveauVisiteur() throws LimiteVisiteurException{
		visiteurs++;
		if(visiteurs > this.getLimiteVisiteur()) {
			throw new LimiteVisiteurException("LimiteVisiteurException");
		}
	}
	
	public int getLimiteVisiteur() {
		return secteursAnimaux.size() * 15;
	}
	
	public void nouvelAnimal(Animal a) throws AnimalDansMauvaisSecteurException {
		for(Secteur sec : secteursAnimaux) {
			if((a.getTypeAnimal()).equals(sec.obtenirType())) {
				sec.ajouterAnimal(a);
				return;
			}
		}
		throw new AnimalDansMauvaisSecteurException("AnimalDansMauvaisSecteurException");
	}
	
	public int nombreAnimaux() {
		int taille = 0;
		for(Secteur sec : secteursAnimaux) {
			taille+= sec.getNombreAnimaux();
		}
		return taille;
	}
	

}
