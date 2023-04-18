package _2023_04_18;

import java.util.*;

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

    /**
     * [1 200 2 201 3 202 4 5 6] -- 6
     */
    private static int getLongestSequenceEvgeny(int[] nums) {
        int[] array = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(array));
        int max = 1;
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] == 1) {
                temp++;
            } else if (array[i] - array[i - 1] == 0) {
                continue;
            } else if (temp > max) {
                max = temp;
                temp = 1;
            }
        }
        return max;
    }

    private static int getLongestSequence(int[] nums) {
       HashSet<Integer> numSet = new HashSet<>();
       for (int n : nums) {
           numSet.add(n);
       }

       int maxSequenceLength = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentSequenceLength = 1;

            if (!numSet.contains(currentNum - 1)) {
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSequenceLength += 1;
                }
                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
            }
        }
        return maxSequenceLength;
    }

    public static void main(String[] args) {
//        String s = "abccbabadbbccbacbdbcbadcbcdacbabadbbccbacbdbcbadcbcbcabdcbabadbbccbacbdbcb";
//        String tem = "cbacbdbcbadcbcbcabdcbabadbbccbacbdbcb";
//
//        String s1 = "abccba";
//        String tem1 = "abc";
//
//        System.out.println(getArrLeraAndVlad(s, tem));
//        System.out.println(getArr(s, tem));

        int[] a = {1, 200, 2, 1010, 1011, 201, 3, 1020, 202, 1012, 1013, 1014, 1016, 1015, 1019, 1018, 1017, 4, 6, 5};
        int[] b = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(getLongestSequence(a));
      //  System.out.println(getLongestSequence(b));
    }
}