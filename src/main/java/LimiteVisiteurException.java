
public class LimiteVisiteurException extends Exception{
	public LimiteVisiteurException(String msg) {
		super(msg);
		System.out.println("La limite de visiteurs a été dépassée");
		
	}
}
