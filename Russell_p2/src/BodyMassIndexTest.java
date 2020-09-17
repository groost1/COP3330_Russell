import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BodyMassIndexTest {
	@Test
	public void bmiUnderweightTest() {
		BodyMassIndex test = new BodyMassIndex(70, 120);
		
		assertEquals(test.getBMI(), 17.22);
		assertEquals(test.getCategory(), "Underweight");
	}
	
	@Test
	public void bmiNormalWeightTest() {
		BodyMassIndex test = new BodyMassIndex(70, 130);
		
		assertEquals(test.getBMI(), 18.65);
		assertEquals(test.getCategory(), "Normal weight");
	}
	
	@Test
	public void bmiOverweightTest() {
		BodyMassIndex test = new BodyMassIndex(70, 180);
		
		assertEquals(test.getBMI(), 25.82);
		assertEquals(test.getCategory(), "Overweight");
	}
	
	@Test
	public void bmiObesityTest() {
		BodyMassIndex test = new BodyMassIndex(70, 220);
		
		assertEquals(test.getBMI(), 31.56);
		assertEquals(test.getCategory(), "Obesity");
	}
	
	
	
}
