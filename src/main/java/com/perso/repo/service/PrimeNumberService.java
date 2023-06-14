package com.perso.repo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static java.util.stream.IntStream.range;

@Service
public class PrimeNumberService {

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> calculate(Integer number) {

        if (0 < number && number < 2) {
            throw new IllegalArgumentException(number + " must be greater than 2");
        }
        if (number.intValue() == 0) {
            throw new NullPointerException(number + " must not be null");
        }
        var primeNumbers = new ArrayList<Integer>();
        int[] index = range(0, number).toArray();
        for (int i : index) {
            if (isPrime(i)) {
                primeNumbers.add(i);

            }
        }
        return primeNumbers;
    }


}
