package banos.ms.beer.calc;

/**
 * [Author]			Mike Banos
 * [Date]			05/13/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Calculator for alchohol by volume.
 */
public class ABVCalculator {
	/**
	 * Calculate ABV from gravities.
	 * @param og The original gravity.
	 * @param fg The final gravity.
	 * @return The ABV.
	 */
	public static double calculate(final double og, final double fg) {
		return 76.08 * (og - fg) / (1.775 - og) * fg / 0.794;
	}
}
