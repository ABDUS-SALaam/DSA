
import java.util.*;

public class BSTImplementation {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // System.out.println("Is empty : " + bst.isEmpty());
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(6);
        // bst.insert(7);
        bst.inOrderTraversal();
        // bst.printInLevelTraversal();
        // System.out.println("The tree is : " + Arrays.toString(bst.getValues().toArray()));
        // System.out.println("Height is " + bst.height());
    }
}

class BinarySearchTree {

    static class Node {

        public Node(int value) {
            this.value = value;
        }
        Node left;
        Node right;
        int value;
    }
    private Node head;

    public Node gethead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int value) {
        head = insert(head, value);
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
        return node;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> al = new ArrayList<>();
        getValues(al, head);
        return al;
    }

    public void printInLevelTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        System.out.println("The tree is as follows");
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.value + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        System.out.println("");
    }

    private void getValues(ArrayList<Integer> al, Node head) {

        if (head == null) {
            return;
        }
        al.add(head.value);
        getValues(al, head.left);
        getValues(al, head.right);
    }

    public int height() {
        return height(head);
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.head);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
