import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeRacerTest {
    boolean[] trueIsNotPrime;
    private static final int CHECKPRIMESBELOW = 10000;

    @Before
    public void altMethodFindPrimes() {
        trueIsNotPrime = new boolean[CHECKPRIMESBELOW];
        int weeder = 2;
        //Go through the entire array, makeing true all non-primes
        while (weeder < trueIsNotPrime.length) {
            /* Stop at first encountered number not a multiple of
             *  any prime below it. By definition, it is prime. */
            while (weeder<trueIsNotPrime.length && trueIsNotPrime[weeder] == true) {
                weeder++;
            } //Remove all multiples of that prime except itself
            for (int j = 2; j * weeder < trueIsNotPrime.length; j++) {
                trueIsNotPrime[weeder*j] = true;
            }
            weeder++;
        }
    }

    @Test
    public void compareMethodsResults() {
        final PrimeRacer racer = new PrimeRacer();
        for (int placeInArrray = 2; placeInArrray < trueIsNotPrime.length; placeInArrray++) {
            if (!trueIsNotPrime[placeInArrray]) {
                Assert.assertEquals(
                        placeInArrray,
                        racer.getPrimeForChecking() );
            }
        }
    }

    @After
    public void cleanUp() {
        trueIsNotPrime = null;
    }
}
