package net.praqma.roadshow;

import net.praqma.roadshow.model.CalculatorModel;
import net.praqma.roadshow.model.CalculatorModelImpl;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculatorModel {
	
	public static CalculatorModel model;
    public static double expectedResult;
	
	@BeforeClass 
	public static void createModel() {		
		model = new CalculatorModelImpl();
        expectedResult = new Double(7.5);
	}
	
	@Test
	public void addTest() {	
	 	Number number = model.add(new Double(2.5), new Integer(5));
	 	assertEquals(expectedResult,number.doubleValue(), 0d);	 	
	}
	
	@Test
	public void subtractTest() {
		Number number = model.subtract(new Double(12.5), new Integer(5));
		assertEquals(expectedResult,number.doubleValue(), 0d);
	}
	
	@Test
	public void divisionTest() {
		Number number = model.divide(new Double(15), new Integer(2));
		assertEquals(expectedResult,number.doubleValue(), 0d);
	}
	
	@Test
	public void multiplyTest() {
		Number number = model.multiply((expectedResult/2)*2, 2);
		assertEquals(expectedResult,number.doubleValue(), 0d);		
	}
	
}