package net.praqma.roadshow.unit;

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
	public void addTestOneParameter() {	
	 	Number number = model.add(new Double(2.5));
	 	assertEquals(0,number.doubleValue(), 0d);	 	
	}
    
    @Test
    public void subtractTest() {
        Number number = model.subtract(new Double(2.5), new Integer(5));
        assertEquals(-2.5d, number.doubleValue(),0.0000000000d);
    }
    
    @Test
    public void subtractTestOneParameter() {
        Number number = model.subtract(new Integer(5));
        assertEquals(0d, number.doubleValue(),0.0000000000d);
    }
    
    @Test
    public void testMultiplyPossiblePermutaions() {
        Double numberZero = model.multiply(0d,new Double(5.0d)).doubleValue();
        assertEquals(0d,numberZero,0d);
        
        Double numberOrigin = model.multiply(null, new Double(5.0d)).doubleValue();
        assertEquals(5d, numberOrigin, 0d);
        
        Double numberBothOk = model.multiply(new Double(2),new Double(5)).doubleValue();
        assertEquals(10d, numberBothOk, 0d);        
    }
        
    @Test
    public void testCheckOperands() {
        Number[] illegaArray = new Number[2];
        illegaArray[0] = new Double(2);
        illegaArray[1] = null;
        
        Number[] illegaArray2 = new Number[1];
        illegaArray2[0] = new Double(2);
        
        assertEquals(false, ((CalculatorModelImpl)model).checkOperands(illegaArray));
        assertEquals(false, ((CalculatorModelImpl)model).checkOperands(illegaArray2));
        
        Number[] legalArray = new Number[2];
        legalArray[0] = new Double(2);
        legalArray[1] = new Integer(-99);
        assertEquals(true, ((CalculatorModelImpl)model).checkOperands(legalArray));
        
        
    } 
	
}