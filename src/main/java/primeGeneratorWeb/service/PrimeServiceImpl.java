package primeGeneratorWeb.service;

import org.springframework.stereotype.Service;
import primeGeneratorWeb.utils.PrimeGenerator;

import java.util.Set;

@Service
public class PrimeServiceImpl implements PrimeService {

    @Override
    public Set<Integer> getPrimes(int number) {
        Set<Integer> primes = PrimeGenerator.primes(number);
        return primes;
    }

}
