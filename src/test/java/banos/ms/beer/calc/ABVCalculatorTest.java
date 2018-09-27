package banos.ms.beer.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Test cases for ABVCalculator.
 */
public class ABVCalculatorTest {
	/**
	 * Basic test for calculating ABV from gravity.
	 * @throws Exception 
	 */
	@Test
	public void test_calculate() {
		assertEquals(4.13, ABVCalculator.calculate(1.032, 1.0), .005);
	}
}
