package primeGeneratorWeb.utils;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class PrimeGenerator {
    /*
    a prime number cannot be divisible by 2,3,5 or another prime number
     */

    public static Set<Integer> primes(int num) {

        if (num < 2) {
            return Collections.emptySet();
        }

        Set<Integer> primes = new TreeSet<>();
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            int sqrt = (int) Math.sqrt(i);
            for (int p : primes) {
                if (p > sqrt) break;
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }

        return primes;
    }
}
