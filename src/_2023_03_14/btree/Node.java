package _2023_03_14.btree;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    //todo
    private static void insert(Node node, Integer value) {

    }

    //todo
    private static void createNode(Node node, Integer value) {

    }

    //todo
    private static Node search(Node node, Integer value) {
        return null;
    }

    //todo
    public static Node getMin(Node node) {
        return null;
    }

    //todo
    private static Node getMax(Node node) {
        return null;
    }

    private static void inOrderTraversal(Node node) {
        if(!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[" + node.value + "]");
        inOrderTraversal(node.right);
    }

    private static void postOrderTraversal(Node node) {
        if(!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.println("[" + node.value + "]");
    }

    private static void directOrderTraversal(Node node) {
        if(!isNodeExist(node)) {
            return;
        }
        System.out.println("[" + node.value + "]");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7};
        Node node = new Node();
        createNode(node, digit[0]);
        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }
    }
}