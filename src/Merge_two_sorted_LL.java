//Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists
// Example 1:

public class Merge_two_sorted_LL {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(2, new Node(4)));
        Node l2 = new Node(1, new Node(3, new Node(4)));
        Node result1 = mergeTwoLists(l1, l2);
        printLinkedList(result1);
    }

    private static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next; // Move head to the newly added node
        }
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return dummy.next;
    }
    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

