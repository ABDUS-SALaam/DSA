
import java.util.Scanner;

class BTImplementation {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.display();
    }
}

final class BinaryTree {

    private Node root;

    public BinaryTree() {
        populate(new Scanner(System.in));
    }

    private void populate(Scanner scanner) {
        System.out.println("Enter the root node value");
        int value = scanner.nextInt();
        Node node = new Node(value);
        populate(node, scanner);
        this.root = node;
    }

    private void populate(Node node, Scanner scanner) {
        System.out.println("Does " + node.value + " has left value");
        boolean hasLeft = scanner.nextBoolean();
        if (hasLeft) {
            System.out.println("Enter the value left to " + node.value);
            int leftValue = scanner.nextInt();
            Node leftNode = new Node(leftValue);
            populate(leftNode, scanner);
            node.left = leftNode;
        }
        System.out.println("Does " + node.value + " has right value");
        boolean hasRight = scanner.nextBoolean();
        if (hasRight) {
            System.out.println("Enter the value right to " + node.value);
            int rightValue = scanner.nextInt();
            Node rightNode = new Node(rightValue);
            populate(rightNode, scanner);
            node.right = rightNode;
        }
    }

    public void display() {
        System.out.println(root.value);
        display(root.left, "\t");
        display(root.right, "\t");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    static class Node {

        public Node(int value) {
            this.value = value;
        }
        Node left;
        Node right;
        int value;
    }
}
