package banos.ms.beer.calc;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		International bittering units calculator.
 */
public class IBUCalculator {
	/**
	 * Calculate IBUs.
	 * @param alphaAcid The hop alpha acid percent.
	 * @param ounces The hop amount.
	 * @param utilization The expected utilization (0.06 - 0.3).
	 * @param wortVolume The final wort volume.
	 * @return
	 */
	public static double calculate(final double alphaAcid, final double ounces, 
			final double utilization, final double wortVolume) {
		return (ounces * 7462 * utilization * alphaAcid) / wortVolume;
	}
}
