package _2023_04_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {
    /**
     * String s = "a)b(c)d" - "ab(c)d"
     * String s = "))((" - ""
     * String s = "(a(b(c)d)" - "a(b(c)d)"
     */
    private static String minRemove(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) {
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }

    /**
     * Подряд идущие цифры *
     * [10 5 2 6] k = 100
     * < 100
     * [10] [5] [2] [6] [10 5]
     * [5 2]  [2 6]  [5 2 6]
     */

    private static List<List<Integer>> subArr(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        //On+On+k
        for (int num : nums) {
            if (num < k) {
                result.add(Collections.singletonList(num));
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > k) {
                continue;
            }
            List<Integer> integerList = new ArrayList<>();
            if (nums[i] * nums[i + 1] < k) {
                integerList.add(nums[i]);
            } else {
                continue;
            }

            int mult = nums[i];
            int x = i + 1;
            while (mult < k && x < nums.length) {
                if (mult * nums[x] < k) {
                    integerList.add(nums[x]);
                }
                mult = mult * nums[x];
                x++;
            }
            result.add(integerList);
        }
        return result;
    }

    //WINNER!!!
    public static List<List<Integer>> methodVladislav(int[] arr, int max) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            List<Integer> l1 = new ArrayList<>();

            for (int j = i; j < arr.length; j++) {
                if (x < max) {
                    l1.add(arr[j]);
                    List<Integer> l2 = new ArrayList<>(l1);
                    res.add(l2);
                    if (arr.length > j + 1) {
                        x *= arr[j + 1];
                    }
                }
            }
        }
        return res;
    }

    private static int subArrM(int[] nums, int k) {
        if (k <= 1) return 0;

        int prod = 1;
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            prod *= nums[right];

            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            result = right - left + 1;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
//        String s1 = "a)b(c)d";
//        String s2 = "))((";
//        String s3 = "(a(b(c)d)";
//
//        System.out.println(minRemove(s1));
//        System.out.println(minRemove(s2));
//        System.out.println(minRemove(s3));
        int[] nums1 = {10, 5, 2, 6};
        int[] nums2 = {0, 10, 101, 5, 2, 6};
        int k = 100;

        System.out.println(subArr(nums1, k));
        System.out.println(subArr(nums2, k));
        System.out.println("****************************************");

        System.out.println(methodVladislav(nums1, k));
        System.out.println(methodVladislav(nums2, k));
        System.out.println("****************************************");

        System.out.println(subArrM(nums1, k));
        System.out.println(subArrM(nums2, k));
        System.out.println("****************************************");


    }
}