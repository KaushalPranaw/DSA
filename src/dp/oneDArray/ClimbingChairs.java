package dp.oneDArray;

public class ClimbingChairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingChairs().climbStairs(5));
    }

    //Approach 1: Recursion with Memo
/*    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    int solve(int n, int[] dp){
        if(n==0||n==1||n==2){
            return n;
        }
        if(dp[n]!=-1)
            return dp[n];
        int a=solve(n-1, dp);
        int b=solve(n-2, dp);
        return dp[n]=a+b;
    }*/


    //Approach 2: bottom up
    /*public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    //Approach 3: Constant Space
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a=b;
            b=c;
        }
        return c;
    }

}
