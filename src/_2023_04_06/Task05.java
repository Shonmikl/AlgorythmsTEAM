package _2023_04_06;

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

    public static void main(String[] args) {
        toLowerCaseLera("TYUuuyRE");
    }
}
