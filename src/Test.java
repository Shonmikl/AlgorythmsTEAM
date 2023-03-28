import java.util.ArrayList;

public class Test {

    /**
     * 0000000100001000100000000011
     * 0b0000000
     */


    private static int getBitLera(int bin) {
        int count = 0;
        while (bin != 0) {
            if ((bin & 1) == 1) {
                count++;
            }
            bin = bin >> 1;
        }
        return count;
    }

    private static int getBit(int bin) {
        int res = 0;
        while (bin != 0) {
            bin = bin & (bin - 1);
            res++;
        }
        return res;
    }

    /**
     * ()(()())
     * )()(
     */

    private static boolean pars(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check < 0) {
                return false;
            }
            String oneSymbol = s.substring(i, i + 1);
            if ("(".equals(oneSymbol)) {
                check++;
            } else {
                check--;
            }
        }
        return check == 0;
    }

    public static void main(String[] args) {
//        int a = 0b00000011;
//        System.out.println(a);
//        System.out.println(getBit(a));
        System.out.println(pars(")("));
    }
}