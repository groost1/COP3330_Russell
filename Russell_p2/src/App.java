import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

		while (moreInput()) {
			double height = getUserHeight();
			double weight = getUserWeight();

			BodyMassIndex bmi = new BodyMassIndex(height, weight);
			bmiData.add(bmi);

			displayBmiInfo(bmi);
		}

		displayBmiStatistics(bmiData);
	}

	public static boolean moreInput() {
		System.out.println("Would you like to enter a BMI, Y or N");
		while (true) {
			String checkYesNo = sc.next();
			if (checkYesNo.length() != 1 || (!checkYesNo.equalsIgnoreCase("Y") && !checkYesNo.equalsIgnoreCase("N"))) {
				System.out.println("Please input a Y or N");
			} else {
				return checkYesNo.equalsIgnoreCase("Y");
			}
		}
	}

	public static int getUserHeight() {
		while (true)
			try {
				System.out.println("please enter the input height");
				int inputHeight = sc.nextInt();

				if (inputHeight < 0)
					System.out.println("Please enter a positive Integer");
				else
					return inputHeight;

			} catch (Exception e) {
				System.out.println("Please enter an Integer");
			}
	}

	public static int getUserWeight() {
		while (true)
			try {
				System.out.println("please enter the input weight");
				int inputWeight = sc.nextInt();

				if (inputWeight < 0) {
					System.out.println("please enter a positive Integer");
				} else
					return inputWeight;

			} catch (Exception e) {
				System.out.println("Please enter an Integer");
			}
	}
	
	public static void displayBmiInfo(BodyMassIndex bmi) {
		System.out.println("This user\'s bmi is: " + bmi.getBMI() + ". Which is in the " + bmi.getCategory() + " category.");
	}
	
	public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
		double average = 0;
		
		//adds all of the bmi's to then divide
		for(BodyMassIndex a : bmiData) {
			average += a.getBMI();
		}
		average /= bmiData.size();
		
		System.out.println("The average body mass index is " + average + ".");
	}
}
