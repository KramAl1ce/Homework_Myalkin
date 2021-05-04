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

    public String getKey() {return key;}

//  AVL

    public int getHeight() {
        if (leftNode == null & rightNode == null) {

            return -1;
        }

        else if (leftNode != null & rightNode == null) {

            return 0;
        }

        else if (leftNode == null & rightNode != null) {
            return 0;
        }

        else {
            return Math.max(leftNode.getHeight(), rightNode.getHeight()) + 1;
        }
    }

    public int getBalance() {

        int leftHeight;
        int rightHeight;

        if (leftNode != null) {

            leftHeight = leftNode.getHeight();
        } else {
            leftHeight = -1;
        }

        if (rightNode != null) {
            rightHeight = rightNode.getHeight();
        } else {
            rightHeight = -1;
        }


        return leftHeight - rightHeight;
    }
}
