package dp.oneDArray;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        System.out.println(obj.fibUsingBottmUp(5));
    }

    //using recursion
    /*int fibUsingRecursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibUsingRecursion(n - 1) + fibUsingRecursion(n - 2);
    }*/

    //using fibUsingDP(int n)
    /*int fibUsingDP(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }*/


    //using bottomup
    int fibUsingBottmUp(int n) {
        if (n <= 1)
            return n;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //using constant time -- sometimes not possible
    int fibUsingConstantTime(int n) {
        if (n <= 1)
            return n;

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
