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
		
		//only breaks out on a return statement
		while (true) {
			//I'm using a String instead of a char because of how silly reading in chars are
			String checkYesNo = sc.next();
			
			//checks if there is more input than there should be and if the input is valid
			if (checkYesNo.length() != 1 || (!checkYesNo.equalsIgnoreCase("Y") && !checkYesNo.equalsIgnoreCase("N"))) {
				System.out.println("Please input a Y or N");
			} else {
				return checkYesNo.equalsIgnoreCase("Y");
			}
		}
	}

	public static double getUserHeight() {
		//only breaks out upon the return statement
		while (true)
			//the try block catches when the input is not an int
			try {
				//prompts the user
				System.out.println("please enter the input height");
				double inputHeight = sc.nextDouble();

				//checks if the height is negative
				if (inputHeight < 0)
					System.out.println("Please enter a positive height");
				else
					return inputHeight;

			} catch (Exception e) {
				System.out.println("Please enter an actual height");
			}
	}

	public static double getUserWeight() {
		//only breaks out upon the return statement
		while (true)
			//catches when the input is not a numeric datatype
			try {
				//prompts the user
				System.out.println("please enter the input weight");
				double inputWeight = sc.nextDouble();

				//checks if the weight is negative
				if (inputWeight < 0) {
					System.out.println("please enter a positive weight");
				} else
					return inputWeight;

			} catch (Exception e) {
				System.out.println("Please enter an actual weight");
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
		
		//rounds to the nearest hundredth
		average = Math.round(average * 100) / 100.0;
		
		System.out.println("The average body mass index is " + average + ".");
	}
}
