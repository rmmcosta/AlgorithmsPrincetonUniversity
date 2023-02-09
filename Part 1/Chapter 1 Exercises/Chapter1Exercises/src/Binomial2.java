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
        //double bino = binomial(N, k, p);
        double bino = improvedBinomial(N, k, p, new HashMap<String, Double>());
        System.out.println(bino);
    }

    public static double binomial(int N, int k, double p) {
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double improvedBinomial(int N, int k, double p, Map<String, Double> memo) {
        if ((N == 0) || (k < 0)) return 1.0;
        //lets save calls to memory - memoization
        //if the value is in memory return it otherwise compute it
        String key = computeKey(N, k, p);
        System.out.println(key);
        if (memo.containsKey(key))
            return memo.get(key);
        double bino = (1.0 - p) * improvedBinomial(N - 1, k, p, memo) + p * improvedBinomial(N - 1, k - 1, p, memo);
        memo.put(key, bino);
        return bino;
    }

    public static String computeKey(int N, int k, double p) {
        return String.valueOf(N) + "," + String.valueOf(k) + "," + String.valueOf(p);
    }
}
