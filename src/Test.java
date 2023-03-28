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

    /**
     * asdffuioplkk --> fuioplk(7)
     * drgg --> drg(3)
     * qere --> ger(3)
     * bbbbb --> b(1)
     * "" --> 0
     */

    private static int getLengthStr(String str) {
        int count = 0;

        int[] seen = new int[256];

        for (int i = 0, j = 0; j < str.length(); j++) {
            i = Math.max(i, seen[str.charAt(j)]);
            System.out.println(seen[str.charAt(j)]);

            count = Math.max(count, j - i + 1);
            seen[str.charAt(j)] = j + 1;
            System.out.println(seen[str.charAt(j)]);
            System.out.println("***********************************");
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getLengthStr("abcabcd"));
//        int a = 0b00000011;
//        System.out.println(a);
//        System.out.println(getBit(a));
//        System.out.println(pars(")("));

    }
}