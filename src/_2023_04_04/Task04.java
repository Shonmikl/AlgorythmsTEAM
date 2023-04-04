package _2023_04_04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task04 {
    private boolean isCycleVladislav(ListNode head) {
        if (head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr.next != null) {
            if (!set.add(curr)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    private boolean isCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }

        ListNode current = head;
        ListNode nextTOcurrent = head.next;

        while (current != nextTOcurrent) {
            if (nextTOcurrent == null || nextTOcurrent.next == null) {
                return false;
            }

            current = current.next;
            nextTOcurrent = nextTOcurrent.next.next;
        }

        return true;
    }

    /**
     * @param s [ab#c, ab##, a##c, a#c]
     * @param t [ad#c, c#d#, #a#c, b ]
     * @return [true, true, true, false]
     */

    public static boolean backSpace(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;

        int sSkip = 0;
        int tSkip = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    sSkip = sSkip + 1;
                    sPointer = sPointer - 1;
                } else if (sSkip > 0) {
                    sPointer = sPointer - 1;
                    sSkip = sSkip - 1;
                } else {
                    break;
                }
            }

            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    tSkip = tSkip + 1;
                    tPointer = tPointer - 1;
                } else if (tSkip > 0) {
                    tPointer = tPointer - 1;
                    tSkip = tSkip - 1;
                } else {
                    break;
                }
            }

            if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }

            if ((sPointer >= 0) != (tPointer >= 0)) {
                return false;
            }
            break;
        }
        return true;
    }


    //todo брать с конца строки
    public boolean backSpaceOlga(String s, String t) {
        return false;
    }

    public static boolean backSpaceEvgeny(String s, String t) {
        List<String> collectS = Arrays.stream(s.split("")).collect(Collectors.toList());
        List<String> collectT = Arrays.stream(t.split("")).collect(Collectors.toList());

        if (collectS.get(0).equals("#")) {
            collectS.remove(0);
        }
        for (int i = 0; i < collectS.size(); i++) {
            if (collectS.get(i).equals("#")) {
                collectS.remove(i);
                collectS.remove(i - 1);
            }
        }
        if (collectT.get(0).equals("#")) {
            collectT.remove(0);
        }
        for (int i = 0; i < collectT.size(); i++) {
            if (collectT.get(i).equals("#")) {
                collectT.remove(i);
                collectT.remove(i - 1);
            }
        }
        if (collectS.size() != collectT.size()) {
            return false;
        }

        for (int i = 0; i < collectS.size(); i++) {
            if (!collectS.get(i).equals(collectT.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String[] s = {"ab#c", "ab##", "a##c", "a#c"};
//        String[] t = {"ad#c", "c#d#", "#a#c", "b"};
//        for (int i = 0; i < s.length; i++) {
//            //System.out.println(backSpaceEvgeny(s[i], t[i]));
//            System.out.println(backSpace(s[i], t[i]));
//        }
        System.out.println(backSpace("#aaaaa#aaaaa", "aa#aaaaaaaa#"));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}