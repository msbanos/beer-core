package banos.ms.beer.calc;

import banos.ms.beer.RecipeGrain;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Malt color unit calculator.
 */
public class MCUCalculator {
	/**
	 * Calculate the malt color.
	 * @param grains The color and amount information for the grains.
	 * @param gallons The wort amount in the mash (gallons).
	 * @return The malt color unit.
	 */
	public static float calculate(final Iterable<RecipeGrain> grains, final float gallons) {
		float grainSum = 0;
		
		for (RecipeGrain rg : grains) {
			float contribution = rg.getGrain().getLovibond() * rg.getAmount();
			if (!rg.getAmountUnit().equals("lb")) {
				contribution /= 16;
			}
			
			grainSum += contribution;
		}
		
		return grainSum / gallons;
	}
}
