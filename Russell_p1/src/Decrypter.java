
public class Decrypter {
	static int[] digits;

	public static String decrypt(String input) {
		// convert it to a character array
		// to make it easier to manipulate
		digits = Application.convertToInts(input);

		// perform the decryption method
		swapDigit(1, 3);
		swapDigit(0, 2);
		
		inverseDigits();

		// return the result
		return Application.convertToString(digits);
	}

	
	private static void inverseDigits() {
		
		for (int i = 0; i < digits.length; i++) {
			// perform backwards encryption
			digits[i] = modInverse(digits[i]);
		}
		
	}

	private static int modInverse(int a) {
		// if the original digit + 7 was >= 10
		if (a - 7 < 0) {
			return 10 - Math.abs(a - 7);
		}

		// else just subtract
		return Math.abs(a - 7);
	}

	private static void swapDigit(int aIndex, int bIndex) {
		// store value in a temporary variable
		int temp = digits[aIndex];

		// swaps the values
		digits[aIndex] = digits[bIndex];
		digits[bIndex] = temp;

	}
}
