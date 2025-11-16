package com.scalability.main;

import com.scalability.main.entity.Prime;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.ConstructorParameters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class PrimeOrchestrator {

    @Autowired
    PrimeCalculator primeCalculator;
    private static HashMap<Integer, Prime> runs = new HashMap<>();
    public int createPrime(Integer amountOfPrimes){
        int runId = runs.size();
        Prime prime = runs.computeIfAbsent(runId, k -> new Prime());
        Thread newThread = new Thread(() -> {
            primeCalculator.calculate(prime, amountOfPrimes);
        });
        newThread.start();
        return runId;
    }

    public List<Integer> findPrimesByRunId(Integer runId){
        return runs.get(runId).getPrimes();
    }
}
