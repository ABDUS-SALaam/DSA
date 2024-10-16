
import java.util.*;

// In this code this tree is a complete tree
public class Traversal {

    static class Node {

        Node left = null;
        Node right = null;
        int value;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node head = null;

    public static Node insert(int value) {
        head = insert(head, value);
        return head;
    }

    private static Node insert(Node head, int value) {
        if (head == null) {
            return new Node(value);
        }
        if (head.value > value) {
            head.left = insert(head.left, value);
        }
        if (head.value < value) {
            head.right = insert(head.right, value);
        }
        head.height = Math.max(height(head.left), height(head.right)) + 1;
        return balance(head);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return node.height;
    }

    private static Node balance(Node node) {
        // check left heavy
        if (height(node.left) - height(node.right) > 1) {
            // check left-left heavy
            if (height(node.left.left) > height(node.left.right)) {
                return rightRotate(node);
            }
            // check left-right heavy
            if (height(node.left.left) < height(node.left.right)) {
                Node newLeft = leftRotate(node.left);
                node.left = newLeft;
                return rightRotate(node);
            }
        }
        if (height(node.right) - height(node.left) > 1) {
            // check right-right heavy
            if (height(node.right.right) > height(node.right.left)) {
                return leftRotate(node);
            }
            // check right-left heavy
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private static Node rightRotate(Node node) {
        Node newHead = node.left;
        Node rightSubTree = newHead.right;
        newHead.right = node;
        node.left = rightSubTree;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newHead.height = Math.max(height(newHead.left), height(newHead.right)) + 1;
        return newHead;
    }

    private static Node leftRotate(Node node) {
        Node newHead = node.right;
        Node leftSubTree = newHead.left;
        newHead.left = node;
        node.right = leftSubTree;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newHead.height = Math.max(height(newHead.left), height(newHead.right)) + 1;
        return newHead;
    }

    public static List<List<Integer>> inLevelTraverse() {
        if (head == null) {
            return new LinkedList();
        }
        return inLevelTraverse(head);
    }

    public static void print() {
        print(head);
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        }
        print(head.left);
        System.out.print(head.value + ",");
        print(head.right);
    }

    private static List<List<Integer>> inLevelTraverse(Node head) {
        Queue<Node> q = new LinkedList<>();

        q.offer(head);
        List<Integer> levelList;
        List<List<Integer>> outerList = new LinkedList<>();
        if (head == null) {
            return outerList;
        }
        while (!q.isEmpty()) {
            int levelSize = q.size();
            levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = q.remove();
                levelList.add(node.value);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            outerList.add(levelList);
        }
        return outerList;

    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        for (int i = 0; i < 10; i++) {
            insert(i);
        }
        for (List<Integer> ls : inLevelTraverse()) {
            System.out.println(Arrays.toString(ls.toArray()));
        }
        print();
    }
}
