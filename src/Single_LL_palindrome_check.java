//Single Linked List Palindrome Check
//How it works slow anf fast pointer is used to find the middle of the linked list
//Then the slow pointer is reversed and then compared with the fast pointer
//If the values are not equal then return false
public class Single_LL_palindrome_check {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(2, new Node(1))));
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
