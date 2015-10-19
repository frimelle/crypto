package Lab0;

public class Main {

	/**
	 * Main, decodes a given cipher and prints the result to the console
	 * @param args
	 */
	public static void main(String[] args) {
		CesarCode cc = new CesarCode();
		Scytale st = new Scytale();
		System.out.println( "Cesar Code:" );
		cc.printPlaintext("vtxltk ibvdxw oxkr lbfiex xgvkrimbhg fxmahw");
		System.out.println( "Scytale:" );
		st.printPlainText("IBSTSYLHRDENTTVTHASEOEIXTHIIHIVIMDNNTYISOASEMEFCGDONOUTIRPTOOTOUK");

	}

}
