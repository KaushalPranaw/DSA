package leetcode150.day4;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle cycleDetector = new LinkedListCycle();

        // Create a non-cyclic linked list: 1 -> 2 -> 3 -> 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println("Non-cyclic list has cycle: " + cycleDetector.hasCycle(head1));

        // Create a cyclic linked list: 1 -> 2 -> 3 -> 4 -> (back to 2)
        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        System.out.println("Cyclic list has cycle: " + cycleDetector.hasCycle(head2));

        // Create a list with only one node (no cycle)
        ListNode head3 = new ListNode(1);
        System.out.println("Single node list has cycle: " + cycleDetector.hasCycle(head3));

        // Create an empty list (no cycle)
        ListNode head4 = null;
        System.out.println("Empty list has cycle: " + cycleDetector.hasCycle(head4));

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}
