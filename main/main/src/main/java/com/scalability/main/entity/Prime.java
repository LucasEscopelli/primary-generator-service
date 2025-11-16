package com.scalability.main.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Prime {
    private List<Integer> primes = new ArrayList<>();
    private List<Double> deltaForFinding = new ArrayList<>();
}
