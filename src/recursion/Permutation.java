package recursion;

import java.util.*;

public class Permutation {
    private String[] strings;

    public Permutation(String string) {
        strings = distinctArray(string);
    }

    public Permutation() {
    }

    public String[] getStrings() {
        return strings;
    }

    public void permutation(String[] words, int currentIndex) {
        if (currentIndex == words.length - 1) {
            System.out.println(Arrays.toString(words));
        }

        for (int i = currentIndex; i < words.length; i++) {
            swap(words, currentIndex, i);
            permutation(words, currentIndex + 1);
            swap(words, currentIndex, i);
        }
    }

    private String[] distinctArray(String str) {
        return Arrays.stream(str.split("\\s")).distinct().toArray(String[]::new);
    }

    private static void swap(String[] str, int a, int b) {
        String temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
}
