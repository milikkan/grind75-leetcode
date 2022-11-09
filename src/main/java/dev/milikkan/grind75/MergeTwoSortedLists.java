package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    // time: O(n)
    // space: O(n)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer1= list1;
        ListNode pointer2 = list2;

        if (pointer1 == null) return pointer2;
        if (pointer2 == null) return pointer1;

        ListNode result = new ListNode();
        ListNode rp = result;

        while (true) {
            if (pointer1.val == pointer2.val) {
                rp.val = pointer1.val;
                rp.next = new ListNode();
                rp = rp.next;
                rp.val = pointer2.val;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            } else if (pointer1.val < pointer2.val) {
                rp.val = pointer1.val;
                pointer1 = pointer1.next;
            } else {
                rp.val = pointer2.val;
                pointer2 = pointer2.next;
            }

            if (pointer1 == null) {
                if (pointer2 != null) rp.next = pointer2;
                break;
            }
            if (pointer2 == null) {
                rp.next = pointer1;
                break;
            }

            rp.next = new ListNode();
            rp = rp.next;

        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));

        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        ListNode list3 = new ListNode(5,
                new ListNode(7));

        ListNode list4 = null;

        ListNode result = mergeTwoLists(list1, list2);
        printNodeList(result); // should print 1 2 3 4

        result = mergeTwoLists(list1, list3);
        printNodeList(result); // should print 1 2 4 5 7

        result = mergeTwoLists(list3, list4);
        printNodeList(result); // should print 5 7

    }

    private static void printNodeList(ListNode list) {
        ListNode node = list;

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}