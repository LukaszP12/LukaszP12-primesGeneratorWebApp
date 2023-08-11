package primeGeneratorWeb.utils;

import java.util.Set;
import java.util.TreeSet;

public class PrimeGenerator {
    /*
    a prime number cannot be divisible by 2,3,5 or another prime number
     */

    public static Set<Integer> primes(int num) {

        if (num <= 0) {
            return null;
        }

        Set<Integer> primes = new TreeSet<>();

        for (int i = 2; i <= num; i++) {

            if (i == 2) {
                primes.add(2);
            } else if (i == 3) {
                primes.add(3);
            } else if (i == 5) {
                primes.add(5);
            } else if (!isDivPrime(primes, i)) {
                primes.add(i);
            }

        }

        primes.add(1);
        return primes;
    }

    private static boolean isDivPrime(Set<Integer> primes, int i) {
        return primes.stream().filter(x -> i % x == 0).findAny().isPresent();
    }

}
