//Reverse k elements in a linked list
public class reverse_k_elements_LL {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        Node result = reverseKGroup(head, 3);
        printLinkedList(result);
    }
    private static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            if (count % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    private static Node reverse(Node prev, Node next) {
        Node last = prev.next;
        Node curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
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
    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
