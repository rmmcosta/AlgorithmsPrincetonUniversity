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
        while (!StdIn.isEmpty()) {
            if (StdRandom.bernoulli()) {
                selectedWord = StdIn.readString();
            }
            else {
                StdIn.readString();
            }
        }
        StdOut.print(selectedWord);
    }
}
