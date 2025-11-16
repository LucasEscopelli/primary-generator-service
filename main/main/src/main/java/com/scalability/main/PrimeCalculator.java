package com.scalability.main;

import com.scalability.main.entity.Prime;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeCalculator {
    public int calculate(Prime prime, Integer amountOfPrimes) {

        List<Integer> primes = prime.getPrimes();
        primes.add(2);
        List<Double> deltas = prime.getDeltaForFinding();

        deltas.add(0.0);

        long tsInitial = System.currentTimeMillis();
        double tsD;

        int number = 3;

        while (primes.size() < amountOfPrimes) {
            boolean isPrime = true;

            for (int p : primes) {
                if (p * p > number) break;
                if (number % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(number);
                tsD = (double) (System.currentTimeMillis() - tsInitial);
                deltas.add(tsD);
            }
            number += 2;
        }
        prime.setPrimes(primes);
        prime.setDeltaForFinding(deltas);
        return 0;
    }
}
