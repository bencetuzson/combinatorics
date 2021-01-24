package main.model;

import java.math.BigInteger;

public class Combinatorics {
    private Combinatorics(){}

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }

        BigInteger ret = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }

        return ret;
    }

    public static int nCr(int n, int r) {
        return Integer.parseInt(String.valueOf(factorial(n).divide((factorial(r).multiply(factorial(n - r))))));
    }

    public static int nPr(int n, int r) {
        return Integer.parseInt(String.valueOf(factorial(n).divide((factorial(n - r)))));
    }


}
