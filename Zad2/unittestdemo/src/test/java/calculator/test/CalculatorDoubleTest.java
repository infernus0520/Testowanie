package calculator.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import calculator.CalculatorDouble;

public class CalculatorDoubleTest {
	
	static CalculatorDouble cal;
	
	@BeforeClass
	public static void globalSetUp(){
		cal = new CalculatorDouble();
	}
	
	double tmp = 0.001;
	
	@Test
	public void testAdd(){
		assertEquals(10,cal.add(5, 5),tmp);
	}
	
	@Test
	public void testSub(){
		assertEquals(10,cal.sub(15, 5),tmp);
	}
	
	@Test
	public void testMul(){
		assertEquals(10,cal.mul(2, 5),tmp);
		assertEquals(-10,cal.mul(-2, 5),tmp);
		assertEquals(10,cal.mul(-2, -5),tmp);
	}
	
	@Test
	public void testDiv(){
		assertEquals(3,cal.div(15, 5),tmp);
		assertEquals(2,cal.div(-10, -5),tmp);
	}
	
	@Test
	public void testGreater(){
		assertTrue(cal.greater(5, 4));
	}
	
}
