package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    // time: O(n)
    // space: O(1)
    // solved using Floyd's Tortoise and Hare Algorithm
    public static boolean hasCycle(ListNode head) {
        var back = head;
        var forward = head;

        while (forward != null && forward.next != null) {
            forward = forward.next.next;
            back = back.next;
            if (back == forward) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        var list1Three = new ListNode(3);
        var list1Two = new ListNode(2);
        var list1Zero = new ListNode(0);
        var list1MinusFour = new ListNode(-4);

        list1Three.next = list1Two;
        list1Two.next = list1Zero;
        list1Zero.next = list1MinusFour;
        list1MinusFour.next = list1Two;

        System.out.println(hasCycle(list1Three)); // true

        var list2One = new ListNode(1);
        var list2Two = new ListNode(2);
        list2One.next = list2Two;
        list2Two.next = list2One;

        System.out.println(hasCycle(list2One)); // true

        var list3One = new ListNode(1);
        var list3MinusTwo = new ListNode(-2);
        list3One.next = list3MinusTwo;
        System.out.println(hasCycle(list3One)); // false
    }
}

