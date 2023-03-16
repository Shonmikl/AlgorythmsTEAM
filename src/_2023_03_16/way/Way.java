package _2023_03_16.way;

//P(n,m) = P(n-1, m) + P(n, m-1)
public class Way {
    public static int getWayNumber(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }

        if (n == 1 && m == 1) {
            return 1;
        }

        return getWayNumber(n - 1, m) + getWayNumber(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(getWayNumber(11, 11));
    }
}