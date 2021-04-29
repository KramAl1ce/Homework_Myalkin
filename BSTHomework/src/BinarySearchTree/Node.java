package BinarySearchTree;

public class Node {
    String key;
    Node parNode;
    Node rightNode;
    Node leftNode;

    public Node() {
        key = null;
        parNode = null;
        rightNode = null;
        leftNode = null;
    }

    public Node(String key) {
        this.key = key;
        parNode =  null;
        leftNode = null;
        rightNode = null;
    }

}
