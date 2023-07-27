package utils;

import org.junit.Assert;
import org.junit.Test;
import primeGeneratorWeb.utils.PrimeGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeGeneratorTest {

    @Test
    public void primes_below_30() {
        // given
        List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        HashSet<Integer> expectedPrimes = new HashSet<>(expectedResult);
        int number = 30;

        // when
        Set<Integer> primes = PrimeGenerator.primes(number);

        // then
        Assert.assertEquals(expectedPrimes, primes);
    }

    @Test
    public void primes_below_50() {
        // given
        List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        HashSet<Integer> expectedPrimes = new HashSet<>(expectedResult);
        int number = 50;

        // when
        Set<Integer> primes = PrimeGenerator.primes(number);

        // then
        Assert.assertEquals(expectedPrimes, primes);
    }

    @Test
    public void primes_below_300() {
        // given
        List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163,
                167, 173, 179, 181, 191, 193, 197, 199,
                211, 223, 227, 229, 233, 239, 241, 251,
                257, 263, 269, 271, 277, 281, 283, 293);
        HashSet<Integer> expectedPrimes = new HashSet<>(expectedResult);
        int number = 300;

        // when
        Set<Integer> primes = PrimeGenerator.primes(number);

        // then
        Assert.assertEquals(expectedPrimes, primes);
    }

    @Test
    public void primes_below_500() {
        // given
        List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163,
                167, 173, 179, 181, 191, 193, 197, 199,
                211, 223, 227, 229, 233, 239, 241, 251,
                257, 263, 269, 271, 277, 281, 283, 293,
                307, 311, 313, 317, 331, 337, 347, 349,
                353, 359, 367, 373, 379, 383, 389, 397,
                401, 409, 419, 421, 431, 433, 439, 443,
                449, 457, 461, 463, 467, 479, 487, 491, 499);
        HashSet<Integer> expectedPrimes = new HashSet<>(expectedResult);
        int number = 500;

        // when
        Set<Integer> primes = PrimeGenerator.primes(number);

        // then
        Assert.assertEquals(expectedPrimes, primes);
    }

}