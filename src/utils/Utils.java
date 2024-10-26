package utils;

import java.util.Arrays;

public class Utils {
    private Utils() {
    }

    public static String getSortedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
