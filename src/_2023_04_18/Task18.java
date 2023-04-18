package _2023_04_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task18 {
    /**
     * "cbaebabacd" -- "abc" -- [0, 6]
     * "abab" -- "ab" -- [0, 1, 2]
     */

    private static List<Integer> getArr(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || s == null) {
            return result;
        }

        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (charCounts[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return result;
    }

    private static List<Integer> getArrLeraAndVlad(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> mapP = strToMap(p);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            Map<Character, Integer> mapSub = strToMap(s.substring(i, i + p.length()));
            if (mapSub.equals(mapP)) result.add(i);
        }
        return result;
    }

    private static Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "abccbabadbbccbacbdbcbadcbcdacbabadbbccbacbdbcbadcbcbcabdcbabadbbccbacbdbcb";
        String tem = "cbacbdbcbadcbcbcabdcbabadbbccbacbdbcb";

        String s1 = "abccba";
        String tem1 = "abc";

        System.out.println(getArrLeraAndVlad(s, tem));
        System.out.println(getArr(s, tem));
    }
}