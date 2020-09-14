import java.util.Arrays;

public class Encrypter {
	static int[] digits;

	public static String encrypt(String input) {
		digits = Application.convertToInts(input);
System.out.println(Arrays.toString(digits));
		//perform the encryption operations
		performOps();
		System.out.println(Arrays.toString(digits));
		swapDigit(0, 2);
		swapDigit(1, 3);

		return Application.convertToString(digits);
	}

	// manipulates the digits with arbitrary mathematical ops
	private static void performOps() {
		for (int i = 0; i < digits.length; i++) {
			digits[i] = (digits[i] + 7) % 10;
		}
	}

	private static void swapDigit(int aIndex, int bIndex) {
		// store value in a temporary variable
		int temp = digits[aIndex];

		// swaps the values
		digits[aIndex] = digits[bIndex];
		digits[bIndex] = temp;
	}

	
}
