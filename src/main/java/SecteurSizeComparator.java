import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecteurSizeComparator implements Comparator<Secteur>{


	public int compare(Secteur secteur1, Secteur secteur2) {
		return (secteur1.getNombreAnimaux() - secteur2.getNombreAnimaux());
	}
}
