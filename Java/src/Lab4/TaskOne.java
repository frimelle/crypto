package Lab4;

public class TaskOne {
	
	/**
	 * Calculate (x ^ y) mod n
	 * 
	 * @param long x
	 * @param long y
	 * @param long n
	 * @return long
	 */
	public long calculate( long x, long y, long n) {
		long result = 1; 
		char[] binaryY = Long.toBinaryString( y  ).toCharArray();
		char one = (char) 49; // ASCII value of 1 
		int numberCalculations = 0;
		for( char c: binaryY ) {
			if( c == one ) {
				result = result * result;
				result = result * x;
				numberCalculations++;
			} else {
				result = result * result;
				numberCalculations++;
			}
		}
		
		System.out.println(numberCalculations);
		
		result = result % n;
		return result;
	}

}
