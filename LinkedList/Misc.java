
public class Misc {

    public static void print(Node n) {
        Node head = n;
        if (head == null) {
            return;
        }
        do {
            System.out.print(head.value + " -> ");
            head = head.next;
        } while (head != null);
        System.out.println("End");
    }

    static Node reverseList(Node pointer1, Node pointer2) {
        while (pointer2 != null) {
            Node temp = pointer2;
            pointer2 = pointer2.next;
            temp.next = pointer1;
            pointer1 = temp;
        }
        return pointer1;
    }

    static Node recursiveInsertion(Node head, int position, int value) {
        if (position == 0) {
            Node newNode = new Node(value, head);
            return newNode;
        }
        if (head == null) {
            return null;
        }
        Node prevNode = recursiveInsertion(head.next, position - 1, value);
        head.next = prevNode;
        return head;
    }

    static void sortList(Node head) {
        Node curHead = head;
        while (head != null) {
            if (curHead.value != head.value) {
                curHead.next = head;
                curHead = head;
            }
            head = head.next;
        }
        if (curHead != null) {
            curHead.next = null;
        }
    }

    static int cycleLength(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head.next;
        int count = 0;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                Node temp = slow;
                do {
                    temp = temp.next;
                    count++;
                } while (temp != slow);
                return count;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return count;
    }

    static Node middleNode(Node head) {
        Node middle = null;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    static Node merge(Node firstHead, Node secondHead) {
        if (firstHead == null && secondHead == null) {
            return null;
        }
        if (secondHead == null) {
            return firstHead;
        }
        if (firstHead == null) {
            return secondHead;
        }
        Node head1 = firstHead;
        Node head2 = secondHead;
        Node mergedListHead = null;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                if (mergedListHead == null) {
                    mergedListHead = head1;
                } else {
                    mergedListHead.next = head1;
                    mergedListHead = head1;
                }
                head1 = head1.next;
            } else {
                if (mergedListHead == null) {
                    mergedListHead = head2;
                } else {
                    mergedListHead.next = head2;
                    mergedListHead = head2;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            mergedListHead.next = head1;
        }
        if (head2 != null) {
            mergedListHead.next = head2;
        }
        return firstHead.value <= secondHead.value ? firstHead : secondHead;
    }

    static Node mergeSort(Node head) {
        Node middleNode = middleNode(head);
        if (middleNode == null || middleNode.next == null) {
            return head;
        }
        Node newListHead = middleNode.next;
        middleNode.next = null;
        Node firstList = mergeSort(head);
        Node secondList = mergeSort(newListHead);
        return merge(firstList, secondList);
    }

    public static void main(String[] args) {
        // Node n6 = new Node(60, null);
        // Node n5 = new Node(50, n6);
        Node n4 = new Node(3, null);
        Node n3 = new Node(1, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(4, n2);

        Node head = mergeSort(n1);
        print(head);
        // n6.next = n3;
        // System.out.println("Cycle length is " + cycleLength(n1));
        // sortList(n1);
        // Node head = recursiveInsertion(n1, 4, 50);
        // print(n1);
        // System.out.println("Reverse");
        // Node newHead = reverseList(null, n1);
        // print(newHead);
    }
}

class Node {

    int value;
    Node next;

    Node(int value, Node node) {
        this.value = value;
        this.next = node;
    }
}
