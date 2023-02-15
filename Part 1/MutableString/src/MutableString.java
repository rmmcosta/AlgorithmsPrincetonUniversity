/******************************************************************************
 *  Compilation:  javac MutableString.java
 *  Execution:    java MutableString
 *  Dependencies: System.out.java
 *
 *  Shows that Strings are mutable if you allow reflection.
 *
 ******************************************************************************/

import java.lang.reflect.Field;

public class MutableString {

    public static void main(String[] args) {
        String s = "Immutable";
        String t = "Notreally";

        mutate(s, t);
        System.out.println("t=" + t);
        System.out.println("s=" + s);

        // strings are interned so this doesn't even print "Immutable" (!)
        System.out.println("Immutable");

        mutateAllAs(s);
        System.out.println("All As for s:" + s);
    }

    // change the first min(|s|, |t|) characters of s to t
    public static void mutate(String s, String t) {
        try {
            Field val = String.class.getDeclaredField("value");
            for (Field f : String.class.getDeclaredFields()) {
                System.out.println(f);
            }
            //Field off = String.class.getDeclaredField("offset");
            val.setAccessible(true);
            //off.setAccessible(true);
            int offset = 0;//off.getInt(s);
            byte[] value = (byte[]) val.get(s);
            for (int i = 0; i < Math.min(s.length(), t.length()); i++)
                value[offset + i] = t.getBytes()[i];
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void mutateAllAs(String s) {
        try {
            Field val = String.class.getDeclaredField("value");
            //Field off = String.class.getDeclaredField("offset");
            val.setAccessible(true);
            //off.setAccessible(true);
            int offset = 0;//off.getInt(s);
            byte[] value = (byte[]) val.get(s);
            for (int i = 0; i < s.length(); i++)
                value[i] = 'a';
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}