package banos.ms.beer.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Test cases for IBUCalculator.
 */
public class IBUCalculatorTest {
	/**
	 * Basic test for calculating IBUs.
	 */
	@Test
	public void test_calculate() {
		assertEquals(15.6702, IBUCalculator.calculate(.035, 1.0, 0.3, 5.0));
	}
}
