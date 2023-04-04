package _2023_04_04;

import lombok.ToString;

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

    /**
     * {2 -> 4 -> 3} + {5 -> 6 -> 4}
     * 342 + 465 = 807
     * 7 -> 0 -> 8
     */

    //todo fix it
    public static ListNode addTwoNumbersVladislav(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        while (l1.next != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }

        while (l2.next != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }

        int a = Integer.parseInt(s1.reverse().toString());
        int b = Integer.parseInt(s2.reverse().toString());

        int sum = a + b;

        String res = String.valueOf(sum);
        s1.setLength(0);

        for (int i = 0; i < res.length(); i++) {
            s1.append(res.charAt(i));
        }

        String s = s1.reverse().toString();
        ListNode listNode = new ListNode(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            listNode.next = new ListNode(s.charAt(i));
        }
        return listNode;
    }

    public static ListNode addTwoNumbersCHATGPT(ListNode l1, ListNode l2) {
        // Reverse the input linked lists
        ListNode rev1 = reverseList(l1);
        ListNode rev2 = reverseList(l2);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Add the corresponding digits from the two lists and construct a new list
        while (rev1 != null || rev2 != null) {
            int val1 = rev1 != null ? rev1.val : 0;
            int val2 = rev2 != null ? rev2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (rev1 != null) rev1 = rev1.next;
            if (rev2 != null) rev2 = rev2.next;
        }

        // Handle the final carry if necessary
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        // Reverse the new linked list
        return reverseList(dummy.next);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void reverse(char[] s) {

    }



    public static void main(String[] args) {
//        String[] s = {"ab#c", "ab##", "a##c", "a#c"};
//        String[] t = {"ad#c", "c#d#", "#a#c", "b"};
//        for (int i = 0; i < s.length; i++) {
//            //System.out.println(backSpaceEvgeny(s[i], t[i]));
//            System.out.println(backSpace(s[i], t[i]));
//        }
//        System.out.println(backSpace("#aaaaa#aaaaa", "aa#aaaaaaaa#"));
        /**
         * {2 -> 4 -> 3} + {5 -> 6 -> 4}
         * 342 + 465 = 807
         * 7 -> 0 -> 8
         */
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        System.out.println(addTwoNumbersVladislav(a1, b1));
      //  System.out.println(addTwoNumbersCHATGPT(a1, b1));

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
//        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}