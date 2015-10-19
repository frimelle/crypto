package Lab1;

import java.util.Arrays;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String message = "heycharlie";
		int lengthOnTimePad = 80;
		OneTimePad padA = new OneTimePad( lengthOnTimePad );
		System.out.println("OneTimePad");
		System.out.println( padA.getOneTimePad() );
		System.out.println("Cipher");
		System.out.println( padA.getCipher(message) );
		
		System.out.println("Plaintext");	
		System.out.println(padA.getBinaryMsg(message));

	}

}
