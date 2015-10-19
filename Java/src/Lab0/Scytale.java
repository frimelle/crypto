package Lab0;
/**
 * Class to decrypt a cipher endcoded via scytale
 *
 */
public class Scytale {
	
	/**
	 * Encode the cipher and print the result to the console
	 * @param String cipher
	 */
	public void printPlainText(String cipher) {
		String plaintext = "";
		int cyperlength = cipher.length();
		for( int i = 0; i < cyperlength/2; i++ ) {
			for( int j = 0; j < i; j++ ) {
				for( int k = j; k < cyperlength; k += i ) {
					plaintext += cipher.charAt( k );
				}
			}
			plaintext += '\n';
		}
		System.out.println( plaintext );
	}
}
