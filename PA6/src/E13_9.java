/*
Use recursion to implement a method
public static int indexOf(String text, String str)
that returns the starting position of the first substring of the text that matches str.
Return –1 if str is not a substring of the text.
 */
public class E13_9 {
    public static void main(String[] args) {
        // try the exsample
        System.out.println(indexOf("Mississippi", "sip"));
    }

    public static int indexOf(String text, String str) {
        if (!text.contains(str)) return -1; // Return –1 if str is not a substring of the text.
        else return indexOf(text, str, 0);
    }

    // helper method according to hint
    private static int indexOf(String text, String str, int n) {
        if (text.startsWith(str)) return n;
        else return indexOf(text.substring(1), str, n + 1);
    }
}
