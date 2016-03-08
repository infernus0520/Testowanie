package pl.calculator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	static Calculator cal;
	
	@BeforeClass
	public static void globalSetUp(){
		cal = new Calculator();
	}
	
	@Test
	public void testAdd(){
		assertEquals(10,cal.add(5, 5));
	}
	
	@Test
	public void testSub(){
		assertEquals(10,cal.sub(15, 5));
	}
	
	@Test
	public void testMul(){
		assertEquals(10,cal.mul(2, 5));
		assertEquals(-10,cal.mul(-2, 5));
		assertEquals(10,cal.mul(-2, -5));
	}
	
	@Test
	public void testDiv(){
		assertEquals(3,cal.div(15, 5));
		assertEquals(3,cal.div(-15, -5));
	}
	
	@Test
	public void testGreater(){
		assertTrue(cal.greater(5, 4));
	}
	
	@Test(expected = ArithmeticException.class) 
	public void testAssert(){
		cal.div(5, 0);
	}
	
}
