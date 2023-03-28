package _2023_03_28;

import java.util.HashSet;
import java.util.Set;

//todo
public class StrFind {
    public static void main(String[] args) {
        String str = "asdrffestracpd";
        System.out.println(stringFind(str));
    }

    public static int stringFind(String str) {
        int count = 0;
        Set<String> set = new HashSet<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            Set<Character> currentStr = new HashSet<>();
            currentStr.add(arr[i]);
            i++;
            if (!currentStr.contains(arr[i]))  {
                currentStr.add(arr[i]);
            } else {
                System.out.println(currentStr);
                set.add(currentStr.toString());
                System.out.println(set);
            }

        }
        return count;
    }

}