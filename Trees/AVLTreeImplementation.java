
import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeImplementation {

    public static int hello = 2;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // tree.insert(1);
        // tree.insert(2);
        // tree.insert(3);
        for (int i = 1; i < 32; i++) {
            tree.insert(i);
        }
        tree.levelTraversal();
        System.out.println("height is : " + tree.height());

    }
}

class AVLTree {

    static class Node {

        public Node(int value) {
            this.value = value;
            this.height = 0;
        }
        Node left;
        Node right;
        int value;
        int height;
    }
    private Node head;

    public Node gethead() {
        return this.head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insert(int value) {
        this.head = insert(this.head, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value > value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return balance(node);
    }

    public int height() {
        return height(this.head);
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node leftGrandChild = child.left;
        parent.right = null;
        child.left = parent;
        parent.right = leftGrandChild;
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node rightGrandChild = child.right;
        parent.left = null;
        child.right = parent;
        parent.left = rightGrandChild;
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    private Node balance(Node node) {
        // Left heavy
        if (height(node.left) - height(node.right) > 1) {
            // Left-Left heavy
            if (height(node.left.left) > height(node.left.right)) {
                return rightRotate(node);
            } // Left-Right heavy 
            if (height(node.left.left) < height(node.left.right)) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } // Right heavy
        if (height(node.left) - height(node.right) < -1) {
            // Right-Right heavy
            if (height(node.right.right) > height(node.right.left)) {
                return leftRotate(node);
            } // Right-Left heavy 
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public void levelTraversal() {
        if (this.head == null) {
            System.out.println("No nodes");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.head);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null && queue.isEmpty()) {
                break;
            }
            if (node == null) {
                System.out.println("");
                queue.add(null);
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                System.out.print(node.value + " ");
            }
        }
        System.out.println("");

    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
}
