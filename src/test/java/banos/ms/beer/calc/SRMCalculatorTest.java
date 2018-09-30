package banos.ms.beer.calc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import banos.ms.beer.RecipeGrain;
import banos.ms.beer.ingrediant.Grain;

/**
 * [Author]			Mike Banos
 * [Date]			01/09/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Test cases for SRMCalculator.
 */
public class SRMCalculatorTest {
	/**
	 * Basic test for calculating SRM.
	 */
	@Test
	public void test_calculate() {
		final float mashVolume = 5f;
		
		Grain grain1 = new Grain();
		grain1.setLovibond(35);
		RecipeGrain rg1 = new RecipeGrain();
		rg1.setAmount(16);
		rg1.setAmountUnit("oz");
		rg1.setGrain(grain1);
		
		Grain grain2 = new Grain();
		grain2.setLovibond(20);
		RecipeGrain rg2 = new RecipeGrain();
		rg2.setAmount(3);
		rg2.setAmountUnit("lb");
		rg2.setGrain(grain2);
		List<RecipeGrain> grains = Arrays.asList(rg1, rg2);
		
		assertEquals(11.244085272809514, SRMCalculator.calculate(grains, mashVolume));
	}
}
