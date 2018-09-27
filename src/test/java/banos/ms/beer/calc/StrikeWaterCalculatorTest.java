package banos.ms.beer.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * [Author]			Mike Banos
 * [Date]			05/13/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Tests for calculating the initial strike water temperature.
 */
public class StrikeWaterCalculatorTest {
	/**
	 * Basic test for calculating the strike water temperature.
	 */
	@Test
	public void test_calculate() {
		assertEquals(110.8, StrikeWaterCalculator.calculate(1, 70, 104));
	}
}
