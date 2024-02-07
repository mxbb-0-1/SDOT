// Merg k sorted linked lists and return it as one sorted list
public class Merge_k_sorted_LL {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(4, new Node(5)));
        Node l2 = new Node(1, new Node(3, new Node(4)));
        Node l3 = new Node(2, new Node(6));
        Node[] lists = {l1, l2, l3};
        Node result = mergeKLists(lists);
        printLinkedList(result);
    }
    private static Node mergeKLists(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private static Node mergeKLists(Node[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        Node left = mergeKLists(lists, start, mid);
        Node right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }
    private static Node merge(Node l1, Node l2) {
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
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return dummy.next;
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
        System.out.println();
    }
}
