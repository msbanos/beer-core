package banos.ms.beer.calc;

import banos.ms.beer.RecipeGrain;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Standard reference method calculator.
 */
public class SRMCalculator {
	/**
	 * Calculate the beer color.
	 * @param grains The color and amount information for the grains.
	 * @param gallons The wort amount in the mash (gallons).
	 * @return The malt color unit.
	 */
	public static double calculate(final Iterable<RecipeGrain> grains, final float gallons) {
		return 1.4922 * Math.pow(MCUCalculator.calculate(grains, gallons), 0.6859);
	}
}
