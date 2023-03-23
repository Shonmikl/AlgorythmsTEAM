package _2023_03_23;

public class DigitPalindrome {
    /**
     * 2552 --> true
     * 258 --> false
     * 121 --> true
     * 122 --> false
     */

    private static boolean isDigitPalindrome(int n) {
        String s = "" + n;
        StringBuilder sb = new StringBuilder();
        return sb.reverse().toString().equals(s);
    }

    /**
     * 123 --> 321
     * -123 --> -321
     * 120 --> 21
     */

    private static int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            x *= -1;
            sign = -1;
        }

        int result = 0;
        int max = Integer.MAX_VALUE;

        while (x > 0) {
            int mod = x % 10;

            if (max / 10 > result ||
                    max / 10 == result && max % 10 >= mod) {
                result = result * 10 + mod;
            } else {
                return 0;
            }
            x = x / 10;
        }
        return result * sign;
    }


    public static void main(String[] args) {
        System.out.println(reverse(123));
 //       System.out.println(reverse(-123));
    }
}
