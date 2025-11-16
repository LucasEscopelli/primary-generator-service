package com.scalability.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrimeController {

    @Autowired
    PrimeOrchestrator orchestrator;

    @GetMapping("findAllPrimes/{amountOfPrimes}")
    public int findAllPrimes(@PathVariable int amountOfPrimes) {

        return orchestrator.createPrime(amountOfPrimes);
    }
    @GetMapping("/findPrimeById/{runId}")
    public List<Integer> findPrimeById(@PathVariable int runId){
        return orchestrator.findPrimesByRunId(runId);
    }
}
