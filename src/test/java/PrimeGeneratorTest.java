import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import primeGeneratorWeb.utils.PrimeGenerator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeGeneratorTest {

        @Test
        @DisplayName("Should return empty set when input is less than 2")
        void testNegativeAndZeroInput() {
            Assertions.assertTrue(PrimeGenerator.primes(0).isEmpty(), "0 should return an empty set");
            assertTrue(PrimeGenerator.primes(-5).isEmpty(), "Negative numbers should return an empty set");
            assertTrue(PrimeGenerator.primes(1).isEmpty(), "1 should return an empty set (1 is not prime)");
        }

        @Test
        @DisplayName("Should generate correct primes for small boundary")
        void testSmallBoundary() {
            Set<Integer> primes = PrimeGenerator.primes(10);
            Set<Integer> expected = Set.of(2, 3, 5, 7);

            assertEquals(expected, primes, "Primes up to 10 should be {2,3,5,7}");
        }

        @Test
        @DisplayName("Should include boundary when it is prime")
        void testBoundaryIsPrime() {
            Set<Integer> primes = PrimeGenerator.primes(13);
            assertTrue(primes.contains(13), "13 is prime and should be included");
        }

        @Test
        @DisplayName("Should not include non-prime boundary")
        void testBoundaryIsComposite() {
            Set<Integer> primes = PrimeGenerator.primes(15);
            assertFalse(primes.contains(15), "15 is not prime and should not be included");
        }

        @Test
        @DisplayName("Should return empty set for negative input")
        void shouldReturnEmptySetForNegativeInput() {
            Set<Integer> result = PrimeGenerator.primes(-10);
            assertNotNull(result, "Result should not be null");
            assertTrue(result.isEmpty(), "Negative input should return an empty set");
        }

        @Test
        @DisplayName("Should return only one prime for small upper bounds")
        void testTinyBounds() {
            assertEquals(Set.of(2), PrimeGenerator.primes(2), "Up to 2 → only 2");
            assertEquals(Set.of(2, 3), PrimeGenerator.primes(3), "Up to 3 → {2,3}");
        }

        @Test
        @DisplayName("Should generate larger range correctly")
        void testMediumBoundary() {
            Set<Integer> primes = PrimeGenerator.primes(30);
            Set<Integer> expected = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
            assertEquals(expected, primes, "Primes up to 30 should match known list");
        }

        @Test
        @DisplayName("Should not contain even numbers other than 2")
        void testNoEvenPrimes() {
            Set<Integer> primes = PrimeGenerator.primes(100);
            assertFalse(primes.stream().anyMatch(p -> p % 2 == 0 && p != 2),
                    "No even primes except 2");
        }

        @Test
        @DisplayName("Should generate the correct count of primes for known limits")
        void testPrimeCounts() {
            // π(10) = 4, π(100) = 25, π(1000) = 168
            assertEquals(4, PrimeGenerator.primes(10).size());
            assertEquals(25, PrimeGenerator.primes(100).size());
            assertEquals(168, PrimeGenerator.primes(1000).size());
        }

        @Test
        @DisplayName("Should not throw exception for large inputs")
        void testPerformanceBoundary() {
            assertDoesNotThrow(() -> PrimeGenerator.primes(100000),
                    "Prime generation for 100k should complete without error");
        }
}
