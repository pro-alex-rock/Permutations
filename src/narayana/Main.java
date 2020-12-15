package narayana;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String[] words = "алюминиевый красный красный очень очень компьютер".split("\\s");
        String[] distinctWords = Arrays.stream(words).distinct().toArray(String[]::new);
        permutationGenerator(stringToInt(distinctWords), distinctWords);
    }

    private static int[] stringToInt(String[] permutation) {
        int[] ints = new int[permutation.length];
        for (int i = 0; i < permutation.length; i++) {
            ints[i] = i;
        }
        return ints;
    }

    private static String[] intToString(int[] ints, String[] strings) {
        String[] words = new String[ints.length];
        for (int i = 0; i < ints.length; i++) {
            words[i] = strings[ints[i]];
        }
        return words;
    }

    private static void permutationGenerator(int[] permutation, String[] words) {
        System.out.println(Arrays.toString(words));
        int index = findMaxIndex(permutation);
        while (index != -1) {
            int element = permutation[index];
            int swapIndex = findIndexBiggerElement(permutation, element);
            swap(permutation, index, swapIndex);
            reverse(permutation, index);
            System.out.println(Arrays.toString(intToString(permutation, words)));
            index = findMaxIndex(permutation);
        }
    }

    private static void reverse(int[] permutation, int index) {
        int shift = index + 1;
        for (int i = 0; i < (permutation.length - shift) / 2; i++) {
            int temp = permutation[shift + i];
            permutation[shift + i] = permutation[permutation.length - i - 1];
            permutation[permutation.length - i - 1] = temp;
        }
    }

    private static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }

    private static int findIndexBiggerElement(int[] permutation, int element) {
        for (int i = permutation.length - 1; i >= 0; i--) {
            if (permutation[i] > element) {
                return i;
            }
        }
        return -1;
    }

    private static int findMaxIndex(int[] permutation) {
        for (int i = permutation.length - 2; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
