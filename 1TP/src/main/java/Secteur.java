import java.util.ArrayList;
import java.util.List;

public class Secteur {
	private String typeAnimauxDansSecteur;
	private List<Animal> animauxDansSecteur = new ArrayList<Animal>();
	
	public Secteur(String s) {
		typeAnimauxDansSecteur = s;
	}
	public void ajouterAnimal(Animal a) {
		animauxDansSecteur.add(a);
	}
	
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public String obtenirType() {
		return typeAnimauxDansSecteur;
	}
	
}
