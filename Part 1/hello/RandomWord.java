/* *****************************************************************************
 *  Name:              Ricardo Costa
 *  Coursera User ID:  123456
 *  Last modified:     February 7, 2023
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String selectedWord = "";
        double i = 0;
        while (!StdIn.isEmpty()) {
            i += 1;
            if (StdRandom.bernoulli(1 / i)) {
                selectedWord = StdIn.readString();
            }
            else {
                StdIn.readString();
            }
        }
        StdOut.println(selectedWord);
    }
}
