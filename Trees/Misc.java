
public class Misc {

    public static String preorder;
    public static int index;

    public static TreeNode build(String arr[]) {
        if (index >= arr.length) {
            return null;
        }
        String value = arr[index++];
        if (value.charAt(0) == 'n') {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = build(arr);
        node.right = build(arr);
        return node;

    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            if (preorder != null) {
                preorder += ",null";
            } else {
                preorder = "null";
            }
            return;
        }
        if (preorder != null) {
            preorder += "," + String.valueOf(root.val);
        } else {
            preorder = String.valueOf(root.val);
        }
        preOrder(root.left);
        preOrder(root.right);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        preorder = null;
        preOrder(root);
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode node = build("1,2,null,null,3,null,null".split(","));
        System.out.println(serialize(node));
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
