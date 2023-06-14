package com.perso.repo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrimeNumberServiceTest {

    @Autowired
    PrimeNumberService primeNumbers;

    @BeforeEach
    public void setUp() {
        primeNumbers = new PrimeNumberService();
    }

    /**
     * Implement PrimeNumbers Class
     */
    @Test
    void should_return_first_prime_numbers_before_30() throws Exception {
        // given
        Integer limit = 30;

        // when
        List<Integer> actualPrimeNumbers = primeNumbers.calculate(limit);

        // then
        assertThat(actualPrimeNumbers).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    /**
     * Add a UT which throws an IllegalArgumentException when argument is less than 2
     */
    @Test
    void should_throw_when_argument_is_less_than_2() throws Exception {
        // given
        int less = 1;

        // when
        // then
        assertThatThrownBy(() -> primeNumbers.calculate(less))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(less + " must be greater than 2");

    }


    /**
     * Add a UT which throws an NullPointerException when argument is NULL
     */
    @Test
    void should_throw_when_argument_is_null() throws Exception {
        // given
        Integer nullValue = Integer.valueOf(0);

        // when
        // then
        assertThatThrownBy(() -> primeNumbers.calculate(nullValue))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(nullValue + " must not be null");

    }

}