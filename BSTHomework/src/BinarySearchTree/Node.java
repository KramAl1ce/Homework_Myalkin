package BinarySearchTree;

public class Node {
    String num;
    Node parNode;
    Node rightNode;
    Node leftNode;

    public Node() {
        num = null;
        parNode = null;
        rightNode = null;
        leftNode = null;
    }

    public Node(String num) {
        this.num = num;
        parNode =  null;
        leftNode = null;
        rightNode = null;
    }

    public Node getParNode() {return parNode;}

    public Node getLeftNode() {return  leftNode;}

    public Node getRightNode() {return rightNode;}

    public String getNum() {return num;}

    
}
