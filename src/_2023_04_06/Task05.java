package _2023_04_06;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Task05 {
    /**
     * String s = "POIjhg";
     */

    public static String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void toLowerCaseLera(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('a' + (c - 'A')));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    /**
     * int[] hand = [1 2 3 6 2 3 4 7 8]
     * int w = 3
     * output [1 2 3] [2 3 4] [6 7 8]
     */

    public static boolean getHandLera(int[] hand, int w) {
        Arrays.sort(hand);
        if (hand.length != w * w) {
            return false;
        }
        boolean[] taken = new boolean[hand.length];
        int partLength = hand.length / w;
        for (int i = 0; i < w; i++) {
            int prev = 0;
            int count = 0;
            for (int j = 0; j < hand.length && count < partLength; j++) {
                if (taken[j]) {
                    continue;
                }
                if (count == 0 || prev + 1 == hand[j]) {
                    taken[j] = true;
                    prev = hand[j];
                    count++;
                }
            }
            if (count != partLength) {
                return false;
            }
        }
        return true;
    }

    public static boolean getHand(int[] hand, int w) {
        TreeMap<Integer, Integer> cCounts = new TreeMap<>();
        for (int card : hand) {
//            if (!cCounts.containsKey(card)) {
//                cCounts.put(card, 1);
//            } else {
//                cCounts.replace(card, cCounts.get(card) + 1);
//            }
            cCounts.merge(card, 1, Integer::sum);
        }

        while (cCounts.size() > 0) {
            int firstKey = cCounts.firstKey();
            for (int i = firstKey; i < (firstKey + w); i++) {
                if (!cCounts.containsKey(i)) {
                    return false;
                }
                int c = cCounts.get(i);
                if (c == 1) {
                    cCounts.remove(i);
                } else {
                    cCounts.replace(i, c - 1);
                }
            }
        }
        return true;
    }

    /**
     * @param moves "UD", "LRRL"
     */

    public static boolean runAway(String moves) {
        int x = 0;
//        if (moves.length() % 2 != 0) {
//            return false;
//        }
        for (int i = 0; i < moves.length(); i++) {
            if ('U' == moves.charAt(i) || 'R' == moves.charAt(i)) {
                x++;
            } else x--;
        }
        return x == 0;
    }

    /**
     * int[] arr = [-1 0 -9 8 11 -3 1 5]
     * int target = X
     * <p>
     * Найти сумму трех чисел которые в сумме дадут target.
     * Если такого числа нет, то найти сумму трех чисел, сумма которых максимально
     * близка к значению target.
     */

    public static int threeSum(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int a = i + 1;
            int b = nums.length - 1;
            while (a < b) {
                int currentSum = nums[i] + nums[a] + nums[b];
                if (currentSum == target) {
                    return target;
                }

                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }

                if (currentSum > target) {
                    b--;
                } else a++;
            }
        }
        return result;
    }

    /**
     * int[] king = {1, 1}
     * int[][] queen = {[2,3], [6,2], [5,5]}
     */

    private static List<List<Integer>> queens(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] seen = new boolean[10000][10000];
        for (int[] q : queens) {
            seen[q[0]][q[1]] = true;
        }

        int[] direction = {-1, 0, 1};
        for (int dx : direction) {
            for (int dy : direction) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int x = king[0];
                int y = king[1];

                while (x + dx >= 0 && x + dx < 10000 && y + dy >= 0 && y + dy < 10000) {
                    x += dx;
                    y += dy;

                    if (seen[x][y]) {
                        result.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> queenOlgaMira(int[][] queen, int[] king) {
        List<Integer> res = new ArrayList<>();
        int x = king[0];
        int y = king[1];
        for (int i = 0; i < queen.length; i++) {
            if (x == queen[i][0]) {
                res.add(i);
            } else if (y == queen[i][1]) {
                res.add(i);
            } else if ((queen[i][0] - x) == (queen[i][1] - y)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 3, 4, 5, 6};
//        int target = 2;
//        System.out.println(threeSum(arr, target));
//
//
//        // toLowerCaseLera("TYUuuyRE");
//        //System.out.println(getHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 9}, 3));
//        System.out.println(runAway("UL"));

        int[] king = {1, 2};
        int[][] queen = {{2, 3}, {1, 5}, {1, 1}, {4, 2}, {5, 5}, {2, 7}, {3, 7}, {4, 7}, {3, 5}};
        int[][] queenTEST = {{1998, 3},  {1, 9997}, {9988, 9989}};
        System.out.println(queenOlgaMira(queenTEST, king));
        System.out.println(queens(queenTEST, king));

    }
}

@ToString
class ListNodes {
    int val;
    ListNodes next;

    public ListNodes(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        ListNodes l1 = new ListNodes(1);
        l1.next = new ListNodes(3);

        ListNodes l2 = new ListNodes(2);

        ListNodes res = mergeTwo(l1, l2);
        System.out.println(res);
    }

    /**
     * 1 -> 2 -> 3
     * 4 -> 5 -> 6
     * output 1 - 2 - 3 - 4 - 5 - 6
     * <p>
     * 1 -> 2 - > 7
     * 3 -> 3 -> 11
     * output 1 - 2 - 3 - 3 - 7 - 11
     */

    public static ListNodes mergeTwo(ListNodes l1, ListNodes l2) {
        ListNodes tempNode = new ListNodes(0);
        ListNodes currentNode = tempNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 != null) {
            currentNode.next = l1;
        }

        if (l2 != null) {
            currentNode.next = l2;
        }
        return tempNode.next;
    }
}