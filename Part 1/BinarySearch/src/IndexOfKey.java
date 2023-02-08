import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IndexOfKey {
    public static void main(String[] args) {
        //receives a file with the whitelist numbers
        //receives a file with the numbers
        //the numbers in the whitelist are the ones we should discard and
        //print the ones that aren't
        File file = new File(args[0]);
        try {
            Scanner sc = new Scanner(file);
            List<Integer> whiteNums = new ArrayList<>();
            while (sc.hasNextInt()) {
                whiteNums.add(sc.nextInt());
            }
            sc.close();
            //now let's start reading the input from std in
            Collections.sort(whiteNums);
            Integer[] whiteNumsArr = whiteNums.toArray(new Integer[0]);
            System.out.println("white nums: " + whiteNumsArr.length);
            //System.out.println("White nums:");
            sc = new Scanner(System.in);
            Set<Integer> keysNotFound = new HashSet<>();
            while (sc.hasNextInt()) {
                int key = sc.nextInt();
                int rankValue = rank(whiteNumsArr, key);
                if (rankValue == -1)
                    keysNotFound.add(key);
                //else
                //System.out.println(key + " found at position " + rankValue);
            }
            sc.close();
            System.out.println("keys not found: " + keysNotFound.size());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int rank(Integer[] arr, int key) {
        //returns the position when key present in arr and -1 when not
        //implements the binary search
        int lo = 0;
        int hi = arr.length - 1;//since it's 0 based
        //we will keep reducing the array to half according to the key and the current mid value
        //this is only possible because the array is sorted
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (key == arr[mid])
                return mid;
            //it's in the right half?
            if (key > arr[mid])
                lo = mid + 1;
                //then it's in the left half
            else
                hi = mid - 1;
            //System.out.printf("low: %d, high: %d\n", lo, hi);
        }
        return -1;
    }
}
