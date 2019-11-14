
public class App {
	public static Zoo zoo = new Zoo();
	
	public static void main(String[] args) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException {
		zoo.ajouterSecteur("Canin");
		zoo.ajouterSecteur("Félin");
		Chat chat = new Chat();
		Chien chien = new Chien();
		zoo.nouvelAnimal(chat);
		zoo.nouvelAnimal(chien);
		
		System.out.println("Nombre animaux : "+ zoo.nombreAnimaux());
		
	}
}
