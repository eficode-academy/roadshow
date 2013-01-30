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
    public void addTestMissingOperandAndCornerCase() {
        Number number = model.add(expectedResult);
        assertEquals(0d,number);
        
        Number numberIllegal = model.add(expectedResult,null);
        assertEquals(0d,numberIllegal);
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
    public void divideByZeroTest() {
        Number number = model.divide(new Double(2),0d);
        assertEquals(0d,number);
    }
    
    @Test
    public void divideTestMissingOperandAndCornerCase() {
        Number number = model.divide(expectedResult);
        assertEquals(0d,number);
        
        Number numberIllegal = model.add(expectedResult,null);
        assertEquals(0d,numberIllegal);
    }
    
	
	@Test
	public void multiplyTest() {
		Number number = model.multiply(expectedResult, 2);
		assertEquals(expectedResult*2,number.doubleValue(), 0d);		
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