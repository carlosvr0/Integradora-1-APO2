package exception;

public class SameTimeMovieException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SameTimeMovieException() {
		super ("No puede haber 2 películas que al mismo tiempo en la misma sala");
	}
}
