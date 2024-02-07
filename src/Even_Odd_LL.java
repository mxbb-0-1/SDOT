public class Even_Odd_LL {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node result = evenOddList(head);
        printLinkedList(result);
    }
    private static Node evenOddList(Node head) {
        if (head == null) {
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
