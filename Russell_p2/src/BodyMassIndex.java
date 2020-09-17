
public class BodyMassIndex {
	private double height, weight;

	// just used to make getting the category a little simpler
	private double bmi;

	public BodyMassIndex(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

	public double getBMI() {
		//calculate precisely
		bmi = (double) (703 * weight) / (height * height);
		
		//rounding to the nearest 100th
		bmi = Math.round(bmi * 100) / 100.0;
		
		return bmi;
	}

	public String getCategory() {
		if (bmi > 18.5) {
			if (bmi > 24.9) {
				if (bmi > 29.9) {
					return "Obesity";
				}
				return "Overweight";
			}
			return "Normal weight";
		}
		return "Underweight";
	}
}
