package _2023_04_25;

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
            if(sb.charAt(i) == '(' && open-- > 0) {
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

    private static int subArr(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "a)b(c)d";
        String s2 = "))((";
        String s3 = "(a(b(c)d)";

        System.out.println(minRemove(s1));
        System.out.println(minRemove(s2));
        System.out.println(minRemove(s3));
    }
}
