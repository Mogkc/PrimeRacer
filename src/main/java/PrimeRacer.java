/**
 * PrimeRacer runs the race method for NUM_OF_MILLIS
 */
public class PrimeRacer {
    private static final int NUM_OF_MILLIS = 100; // race method should run no longer than this.

    private long current = 1;

    /**
     * A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
     *
     * @param n {@link long}
     * @return {@link boolean} true, if n is a prime number
     */
    private static boolean isPrime(long n) {
        //No even numbers will be checked for being prime
        //Any even number is divisible by 2
            for (long i=3; i< n; i= i+2) {
                if (n%i == 0)
                    return false;
            }
            return true;
    }


    public static void main(final String[] args) {
        final long timeIsUp = System.currentTimeMillis() + NUM_OF_MILLIS;
        final PrimeRacer racer = new PrimeRacer();
        int k = 0;

        while (true) {
            long p = racer.nextPrimeNumber();
            if (System.currentTimeMillis() < timeIsUp) {
                System.out.println("Prime number found : " + p);
                k++;
            } else {
                break;
            }
        }
        System.out.println("Primes found : " + k);
    }

    private long nextPrimeNumber() {
        if (current <=2)
            return current++;
        //This is for the special cases 2 and 3
        while (true) {
            //All primes greater than 2 are odd.
            //No need to check even numbers
            current+=2;
            if (isPrime(current) )
                return current;
        }
    }
}