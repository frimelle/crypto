package Lab0;
/**
 * Class to decrypt a cipher endcoded via cesar code
 *
 */
public class CesarCode {
	
	/**
	 * Encode the cipher and print the result to the console
	 * @param String cipher
	 */
	public void printPlaintext( String cypher ) {
		char[] cypherArray = cypher.toCharArray();
		char[] plainTextArray = new char[cypherArray.length];
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] alphabetShifted = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
		for( int k = 0; k < alphabet.length; k++ ){
			for( int i = 0; i < alphabet.length; i++ ) {
				for( int j = 0; j < cypherArray.length; j++ ) {
					if( cypherArray[j] == ' ') {
						plainTextArray[j] = cypherArray[j];
					}
					if( cypherArray[j] == alphabet[i] ){
						plainTextArray[j] = alphabetShifted[i + k];// alphabetShifted
					}
				}
			}
			System.out.println(new String(plainTextArray));
		}
	}
}
