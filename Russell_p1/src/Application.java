import java.util.Scanner;

public class Application {
	static Scanner sc = new Scanner(System.in);
	static String input; 
	
	public static void main(String[] args) {
		int run = 1;
		while(run == 1) {
			promptStringInput();
			promptDecideCrypto();
			
			run = promptRunAgain();
		}

	}

	private static void promptStringInput() {
		System.out.println("Input the desired string: ");
		input = sc.next();
	}
	
	private static void promptDecideCrypto() {
		System.out.println("Encrypt(1) or Decrypt(0): ");
		int decide = sc.nextInt();

		if (decide == 1) {
			System.out.println("Your encrypted String is: " + Encrypter.encrypt(input));
		} else {
			System.out.println("Your Decrypted String is " + Decrypter.decrypt(input));
		}
	}

	private static int promptRunAgain() {
		System.out.println("Do you want to run again? 1 or 0: ");
		return sc.nextInt();
	}
	
	/*
	 * GLOBAL HELPER METHODS
	 */
	// converts input String to digits
	public static int[] convertToInts(String input) {
		int[] resArr = new int[input.length()];

		for (int i = 0; i < input.length(); i++) {
			resArr[i] = (int) input.charAt(i) - 48;
		}

		return resArr;
	}

	// converts input digits back into a string
	public static String convertToString(int[] input) {
		String res = "";

		for (int i = 0; i < input.length; i++) {
			res += input[i];
		}

		return res;
	}

}
