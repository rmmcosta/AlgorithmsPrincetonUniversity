import java.util.HashMap;
import java.util.Map;

public class Binomial2 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Wrong number of arguments passed");
            return;
        }
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        //System.out.println(binomial(N, k, p));
        System.out.println(improvedBinomial(N, k, p, new HashMap<>()));
        //System.out.println(binomial1(N, k, p));
        //System.out.println(binomial2(N, k, p));
    }

    // slow
    public static double binomial1(int N, int k, double p) {
        //System.out.println(computeKey(N,k,p));
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) *binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
    }

    // memoization
    public static double binomial2(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) *b[i-1][j];
            }
        }
        return b[N][k];
    }

    public static double binomial(int N, int k, double p) {
        //System.out.println(computeKey(N,k,p));
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
        //return bino;
    }

    public static double improvedBinomial(int N, int k, double p, Map<String, Double> memo) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        //lets save calls to memory - memoization
        //if the value is in memory return it otherwise compute it
        String key = computeKey(N, k);
        //System.out.println(key);
        if (memo.containsKey(key))
            return memo.get(key);
        double bino = (1.0 - p) * improvedBinomial(N - 1, k, p, memo) + p * improvedBinomial(N - 1, k - 1, p, memo);
        memo.put(key, bino);
        return bino;
    }

    public static String computeKey(int N, int k) {
        return N + "," + k;
    }
}