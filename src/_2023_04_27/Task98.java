package _2023_04_27;

import java.util.*;

public class Task98 {
    /**
     * in ["bella", "label", "roller"]
     * out ["e", "l", "l"]
     */

    private static List<String> commonChars(String[] arr) {
        List<String> commonChars = new ArrayList<>();
        int[] minFreq = new int[26];

        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String currentString : arr) {
            int[] charFreq = new int[26];

            for (char c : currentString.toCharArray()) {
                charFreq[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                commonChars.add("" + (char) (i + 'a'));
                minFreq[i]--;
            }
        }
        return commonChars;
    }

    private static char[] commonCharsGPT(String[] str) {
        // Создаем множество символов, которые встречаются в первом слове массива
        List<Character> commonChars = new LinkedList<>();
        for (char ch : str[0].toCharArray()) {
            commonChars.add(ch);
        }

        // Идем по каждому следующему слову и удаляем из множества символы, которых нет в текущем слове
        for (int i = 1; i < str.length; i++) {
            Set<Character> currentChars = new HashSet<>();
            for (char ch : str[i].toCharArray()) {
                currentChars.add(ch);
            }
            commonChars.retainAll(currentChars);
        }

        // Копируем символы из множества в массив
        char[] result = new char[commonChars.size()];
        int i = 0;
        for (char ch : commonChars) {
            result[i++] = ch;
        }

        return result;
    }

    /**
     * [1 1 2 3 3 3 4 5 6]
     * [9 9 8 7 6 6 5 5 5 5 5 5]
     * [1 1 2 2 3 4 5 4]
     */

    private static boolean arrDummy(int[] arr) {
        boolean up = true;
        boolean down = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) up = false;
            if (arr[i] < arr[i + 1]) down = false;
        }
        if (up) return true;
        return down;
    }

    /**
     * String s = ""abbbstrrts";
     * out - "strrts"
     *
     * String s = "cbba"
     * out - "bb"
     */

    public String longestPolin(String s) {

    }

    public static void main(String[] args) {
        String[] arr = {"bella", "label", "roller"};
        // System.out.println(commonChars(arr));
        System.out.println(commonCharsGPT(arr));
    }
}
