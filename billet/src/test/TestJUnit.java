package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import automat.Billetautomat; 

public class TestJUnit {
	
	Billetautomat automat;	

	@Before
	public void setUp() throws Exception {
		automat = new Billetautomat();
	}
		
	@After
	public void tearDown() throws Exception {
		automat = null;
	}
	
	

	@Test
	public void testBilletautomat() {
		
	}
	
	/*
	 * Vi laver vores forventede værdi som er 10. 
	 * Så henter vi billetprisen som programmet outputter (vi caller metoden).
	 * Derefter tester vi om de er lig hinanden.
	 */

	@Test
	public void testGetBilletpris() {
		int expected = 10;
		int actual = automat.getBilletpris();
				assertEquals(expected,actual);
		
	}

	@Test
	public void testIndsætPenge() {
		int expected = 0;
		int actual = automat.getBalance() + 0;
			assertEquals(expected,actual);
	}

	@Test
	public void testGetBalance() {
		int expected = 0;
		int actual = automat.getBalance();
			assertEquals(expected,actual);
	}

	@Test
	public void testReturpenge() {
		int expected = 0;
		int actual = automat.returpenge();
		assertEquals(expected,actual);
	}
	
	/*
	 * Først tester vi om man kan logge ind uden at have adgangskoden eller skrive noget. Og vi forventer at dette bliver false. 
	 */

	@Test
	public void testMontørLoginFalse() { 
		boolean actual = automat.erMontør();
		assertFalse(actual);
		
	}
	
	/*
	 * Vi tester om man kan logge ind med passwordet. Og vi forventer at dette bliver true.  
	 */
	@Test
	public void testMontørLoginTrue() {
		automat.montørLogin("1234");
		boolean result = automat.erMontør();
		assertTrue(result);
	}

	@Test
	public void testGetTotal() {
		int expected = 0;
		int actual = automat.getAntalBilletterSolgt() * automat.getBilletpris();
		assertEquals(expected, actual);
	}
	


	@Test
	public void testGetAntalBilletterSolgt() {
		automat.montørLogin("1234");
		int expected = 0;
		int actual = automat.getAntalBilletterSolgt();
		assertEquals(expected, actual);

	}

	/*
	 * Vi tester her om billetprisen kan ændres og få det forventede output som her er 20. 
	 * Vi bruger adgangskoden her da det er en forudsætning at kun montøren kan ændre prisen.
	 */
	
	@Test
	public void testSetBilletpris() {
		automat.setBilletpris(20);
		automat.montørLogin("1234");
		int expected = 20;
		int actual = automat.getBilletpris();
		assertEquals(expected, actual);
	}

	/*
	 * Vi tester om montøren har adgang til at se antallet af solgte billetter.
	 */
	@Test
	public void testNulstil() {
		automat.montørLogin("1234");
		int expected = 0;
		int actual = automat.getAntalBilletterSolgt();
		assertEquals(expected, actual);
	}
	/*
	 * Vi tester om montøren har tilladelse til at ændre antallet af solgte billetter. 
	 */
	
	@Test
	public void testSetAntalBilletterSolgt() {
		automat.montørLogin("1234");
		automat.setAntalBilletterSolgt(10);
		int expected = 10;
		int actual = automat.getAntalBilletterSolgt();
		assertEquals(expected,actual);
		
	}

	/*
	 * Vi tester om man får montørtilstand uden og med adgangskoden. 
	 */
	@Test
	public void testErMontørTrue() {
		automat.montørLogin("1234");
		boolean actual = automat.erMontør();
		assertTrue(actual);
	}
	
	@Test
	public void testErMontørFalse() {
		automat.erMontør();
		boolean actual = automat.erMontør();
		assertFalse(actual);

}
	
}
