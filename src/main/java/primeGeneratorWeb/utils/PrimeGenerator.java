package primeGeneratorWeb.utils;

import java.util.Set;
import java.util.TreeSet;

public class PrimeGenerator {
    /*
    a prime number cannot be divisible by 2,3,5 or another prime number
     */

    public static Set<Integer> primes(int num) {

        Set<Integer> primes = new TreeSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);

        for (int i = 5; i <= num; i = i + 2) {

            if (!isDivPrime(primes, i)) {
                primes.add(i);
            }

        }

        return primes;
    }

    private static boolean isDivPrime(Set<Integer> primes, int i) {
        return primes.stream().filter(x -> i % x == 0).findAny().isPresent();
    }

}
