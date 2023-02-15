/******************************************************************************
 *  Compilation:  javac MutableInteger.java
 *  Execution:    java MutableInteger
 *  Dependencies: StdOut.java
 *
 *  Shows that Integerss are mutable if you allow reflection.
 *
 ******************************************************************************/

import java.lang.reflect.Field;

public class MutableInteger {

    public static void main(String[] args) {
        Integer x = 17;
        System.out.println(x);
        mutate(x);
        System.out.println(x);
    }

    // change the Integer to 9999999
    public static void mutate(Integer x) {
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(x, 999999999);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}