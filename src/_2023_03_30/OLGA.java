package _2023_03_30;

import java.util.*;

public class OLGA {
    //todo доделать что бы находило все пары
    public static int[] sum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int c = target - nums[i];
            if (map.containsKey(c) && map.get(c) != i)
                return new int[]{i, map.get(c)};

        }
        return new int[]{};
    }

    /**
     * [0 3 2]
     * [3 0 2]
     * [0 1 2 4]
     * [3 0 1]
     */

    private static int miss(int[] arr) {
        int n = arr.length;

        int sum = n * (n + 1) / 2;
        int sum2 = 0;

        for (int i : arr) {
            sum2 += i;
        }
        return sum - sum2;
    }

    private static void missEvgeny(int[] arr) {
        Arrays.sort(arr); // 0,1,3,5
        int temp = arr[0];
        for (int j : arr) {
            if (temp != j) {
                return;
            }
            temp++;
        }
    }

    private static int missLera(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        Map<Integer, Boolean> flags = new HashMap<>();

        for (int j : arr) {
            min = Math.min(min, j);
            max = Math.max(max, j);

            flags.put(j, true);
        }

        for (int i = min + 1; i < max; i++) {
            if (!flags.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int[] getArr(int n) {
        int[] a = new int[n];
        for (int i = 2; i < n; i++) {
            a[i] = i;
        }
        a[a.length - 1] = 0;
        return a;
    }

    /**
     * [1 2 3 4 1 5 4 2 9]
     * 11 --> 2-9
     * 5
     * 3
     * 2
     */

    private static int minSubArray(int[] nums, int s) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int valSum = 0;

        for (int i = 0; i < nums.length; i++) {
            valSum += nums[i];

            while (valSum >= s) {
                result = Math.min(result, i + 1 - left);
                valSum -= nums[left];
                left++;
            }
        }
        return (result != Integer.MAX_VALUE) ? result : 0;
    }

    /**
     * 128 --[1 2 8]
     * 129
     * <p>
     * int left = 21
     * int right = 987
     * [21...........987]
     */

    private static List<Integer> self(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) {
                    break;
                }
            }
            if (j == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 10_000_000;
        int arr[] = {1, 2, 3, 4, 1, 5, 4, 2, 9};
        System.out.println(self(15, 129));
//        System.out.println(minSubArray(arr, 11));

//        long m = System.currentTimeMillis();
//        System.out.println(miss(getArr(n)));
//        System.out.println("Mikhail: " + (System.currentTimeMillis() - m));

//        long l = System.currentTimeMillis();
//        System.out.println(missLera(getArr(n)));
//        System.out.println("Lera: " + (System.currentTimeMillis() - l));

//        long e = System.currentTimeMillis();
//        missEvgeny(getArr(n));
//        System.out.println("Evgeny: " + (System.currentTimeMillis() - e));
    }
}