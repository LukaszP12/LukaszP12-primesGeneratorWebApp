package primeGeneratorWeb.service;

import org.springframework.stereotype.Service;
import primeGeneratorWeb.utils.PrimeGenerator;

import java.util.Set;

@Service
public class PrimeService {

    public Set<Integer> generatePrimes(int number) {
        return PrimeGenerator.primes(number);
    }
}
