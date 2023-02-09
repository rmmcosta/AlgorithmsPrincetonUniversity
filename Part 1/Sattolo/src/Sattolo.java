import java.util.HashSet;
import java.util.Set;

public class Sattolo {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        printArr(arr);
        int[] cycledArr = cycle(arr);
        printArr(cycledArr);
    }

    static int[] cycle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //generate a random between i and the arr last pos
            double f = Math.random()/Math.nextDown(1.0);
            double x = i*(1.0 - f) + (arr.length-1)*f;
            int temp = arr[i];
            arr[i] = arr[(int)x];
            arr[(int)x] = temp;
        }
        return arr;
    }

    static void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}