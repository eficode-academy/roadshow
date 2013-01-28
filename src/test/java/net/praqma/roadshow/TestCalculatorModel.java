package net.praqma.roadshow;

import static org.junit.Assert.assertEquals;
import net.praqma.roadshow.model.CalculatorModel;
import net.praqma.roadshow.model.CalculatorModelImpl;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculatorModel {
	
	public static CalculatorModel model;
	
	@BeforeClass 
	public static void createModel() {		
		model = new CalculatorModelImpl();
	}
	
	@Test
	public void addTest() {
		double expectedResult = 7.5d;		
	 	Number number = model.add(new Double(2.5), new Integer(5));
	 	assertEquals(expectedResult,number.doubleValue(), 0d);	 	
	}
	
	@Test
	public void subtractTest() {
		double expectedResult = 7.5d;
		Number number = model.subtract(new Double(12.5), new Integer(5));
		assertEquals(expectedResult,number.doubleValue(), 0d);
	}
	
	@Test
	public void divisionTest() {
		double expectedResult = 7.5d;
		Number number = model.subtract(new Double(15), new Integer(2));
		assertEquals(expectedResult,number.doubleValue(), 0d);
	}
	
	@Test
	public void multiplyTest() {
		double expectedResult = 7.5d;
		Number number = model.subtract((expectedResult/2)*2, 2);
		assertEquals(expectedResult,number.doubleValue(), 0d);		
	}
	
}