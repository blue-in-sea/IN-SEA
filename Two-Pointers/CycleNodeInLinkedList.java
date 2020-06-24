/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
 
public class CycleNodeInLinkedList {
    // Time: O(n)
    // Space: O(1)
    public ListNode detectCycle(ListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        // 1. find the meet point where slow and fast cross if cycle exists 
        ListNode intersect = meetPoint(head);
        if (intersect == null) {
            return null;
        }
        // 2. find the cycle node 
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public ListNode meetPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
