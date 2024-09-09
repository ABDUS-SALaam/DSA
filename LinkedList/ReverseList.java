
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseList {

    public static ListNode getNode(ListNode head, int index) {
        ListNode node = null;
        int count = 0;
        while (count < index) {
            count++;
            if (node == null) {
                node = head;
            } else {
                node = node.next;
            }
        }
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevNode = getNode(head, left - 1);
        ListNode nextNode = getNode(head, right + 1);
        ListNode startNode = getNode(head, left);
        ListNode endNode = getNode(head, right);
        endNode.next = null;
        ListNode reverseHead = reverseList(startNode);
        if (prevNode != null) {
            prevNode.next = reverseHead;
        }
        startNode.next = nextNode;
        return left == 1 ? reverseHead : head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("END");
    }

    public static ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = findMiddle(head);
        ListNode newMiddleNode = reverseList(middleNode);
        while (head != null && newMiddleNode != null) {
            if (head.value != newMiddleNode.value) {
                return false;
            }
            head = head.next;
            newMiddleNode = newMiddleNode.next;
        }
        return true;
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        if (fast.next == null) {
            return;
        }
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHead = reverseList(slow);
        if (temp != null) {
            temp.next = null;
        }
        ListNode curr = null;
        while (head != null || reversedHead != null) {
            if (head != null) {
                if (curr != null) {
                    curr.next = head;
                }
                curr = head;
                head = head.next;
            }
            if (reversedHead != null) {
                if (curr != null) {
                    curr.next = reversedHead;
                }
                curr = reversedHead;
                reversedHead = reversedHead.next;
            }
        }
    }

    public static int ListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Leetcode 25
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        if (head == null || head.next == null) {
            return head;
        }
        int length = ListLength(head);
        int count = 0;
        ListNode newHead = null;
        ListNode curr = head;
        ListNode tail = null;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode prev = null;
            ListNode start = curr;
            if (count >= length - (length % k)) {
                if (tail != null) {
                    tail.next = curr;
                }
                break;
            }
            for (int i = 0; i < k && curr != null; i++) {
                count++;
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (tail != null) {
                tail.next = prev;
            }
            if (newHead == null) {
                newHead = prev;
            }
            tail = start;

        }
        return newHead;
    }

    // Reverse alternate K groups
    public static ListNode reverseAlternateKGroups(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            count++;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        count = 0;
        head.next = curr;
        while (count < k && curr != null) {
            count++;
            head = curr;
            curr = curr.next;
        }
        if (curr != null) {
            head.next = reverseAlternateKGroups(curr, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l9 = new ListNode(90, null);
        ListNode l8 = new ListNode(80, l9);
        ListNode l7 = new ListNode(70, l8);
        ListNode l6 = new ListNode(60, l7);
        ListNode l5 = new ListNode(50, l6);
        ListNode l4 = new ListNode(40, l5);
        ListNode l3 = new ListNode(30, l4);
        ListNode l2 = new ListNode(20, l3);
        ListNode l1 = new ListNode(10, l2);
        ListNode head = reverseAlternateKGroups(l1, 3);
        print(head);
        // reorderList(l4);
        System.out.println("Done");
        // System.out.println(isPalindrome(l4));
    }

}

class ListNode {

    int value;
    ListNode next;

    ListNode(int value, ListNode node) {
        this.value = value;
        this.next = node;
    }
}
