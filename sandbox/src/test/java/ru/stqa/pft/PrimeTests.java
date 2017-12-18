package ru.stqa.pft;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrimes() {
//        System.out.println(Integer.MAX_VALUE);
       Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrimes() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
