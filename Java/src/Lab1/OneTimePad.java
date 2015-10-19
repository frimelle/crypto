package Lab1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * class to generate an encrypted message with a one time pad.
 */
public class OneTimePad {
	
	private int[] oneTimePad;
	
	public OneTimePad(int length) {
		this.oneTimePad = this.generateOneTimePad( length );
	}
	
	/**
	 * generate the one time pad
	 * @param int length
	 * @return int[]
	 */
	private int[] generateOneTimePad( int length ) {
		Random r = new Random();
		int[] oneTimePad = new int[length];
		for(int i = 0; i < length; i++) {
			oneTimePad[i] = r.nextInt(2);
		}
		
		return oneTimePad;
	}
	
	/**
	 * convert a String to a binary integer array
	 * @param String txt
	 * @return int[]
	 */
	public int[] toBinary(String txt) {
		byte[] bytes = txt.getBytes(StandardCharsets.US_ASCII);
		int[] binary = new int[bytes.length * 8];
		int counter = 0;
		for (byte b : bytes) {
		     int val = b;
		     for (int i = 0; i < 8; i++) {
		        int bi = (val & 128) == 0 ? 0 : 1;
		        val <<= 1;
		        binary[counter] = bi;
		        counter++;
		        
		     }
		  }
		return binary;
	}
	
	/**
	 * encode a given plain text with this one time pad
	 * @param String plaintext
	 * @return int[]
	 */
	private int[] encodePlaintext( String plaintext ) {	
		int[] plaintextASCII = this.toBinary(plaintext);
		
		int[] encodedPlaintext = new int[plaintextASCII.length];
		int counter = 0;
		for(int i = 0; i < plaintextASCII.length; i++) {
			if (counter >= encodedPlaintext.length){
				counter = 0;
			}
			encodedPlaintext[i] = plaintextASCII[i] ^ this.oneTimePad[counter];
			
			counter++;
		}
		return encodedPlaintext;
	}
	
	/**
	 * get a String with the one time pad
	 * @return String
	 */
	public String getOneTimePad() {
		String result = "";
		int[] otp = this.oneTimePad;
		for( int i= 0; i < otp.length; i++ ) {
			if( (i % 8) == 0 ){
				result += " ";
			}
			result += otp[i];
		}
		return result;
	}
	
	/**
	 * get a String with the one cipher generated 
	 * with the one time pad from a given message
	 * @param String message
	 * @return String
	 */
	public String getCipher(String message) {
		String result = "";
		int[] ep = this.encodePlaintext(message);
		for( int i= 0; i < ep.length; i++ ) {
			if( (i % 8) == 0 ){
				result += " ";
			}
			result += ep[i];
		}
		return result;
	}
	
	/**
	 * get a String with the String in the bi
	 * @param message
	 * @return
	 */
	public String getBinaryMsg(String message) {
		String result = "";
		int[] tb = this.toBinary(message);
		for( int i= 0; i < tb.length; i++ ) {
			if( (i % 8) == 0 ){
				result += " ";
			}
			result += tb[i];
		}
		return result;
	}
}
