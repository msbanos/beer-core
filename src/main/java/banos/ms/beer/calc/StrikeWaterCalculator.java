package banos.ms.beer.calc;

/**
 * [Author]			Mike Banos
 * [Date]			05/13/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Calculator for strike water temparature.
 * 		@link http://howtobrew.com/book/section-3/the-methods-of-mashing/calculations-for-boiling-water-additions
 */
public class StrikeWaterCalculator {
	/**
	 * Calculate the strike water temperature.
	 * @param r The ratio of water to grain in quarts per pound.
	 * @param T1 The initial temperature (F) of the mash.
	 * @param T2 The target temperature (F) of the mash.
	 * @return The temperature.
	 */
	public static double calculate(final double r, final double T1, final double T2) {
		return (.2 / r) * (T2 - T1) + T2;
	}
}
