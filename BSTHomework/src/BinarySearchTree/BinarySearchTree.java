package BinarySearchTree;

import java.util.Objects;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = new Node();
    }

    public BinarySearchTree(String key) {
        root = new Node(key);
    }

    public void insert(String num) {
        if (root == null) {
            root = new Node(num);
        }
    }


    private Node getSuccessor(Node focusNode) {
        if (focusNode.rightNode != null) {
            focusNode = focusNode.rightNode;
            while (focusNode.leftNode != null) {
                focusNode = focusNode.leftNode;
            }
            return focusNode;
        } else {
            while (focusNode.parNode != null) {
                Node focusNodeParent = focusNode.parNode;
                if (focusNodeParent.leftNode.equals(focusNode)) {
                    return focusNodeParent;
                } else {
                    focusNode = focusNodeParent;
                }
            }

            return null;
        }
    }

    private static boolean nodeExists(Node focusNode, String whatNode) {
        boolean doesExist;
        switch (whatNode) {
            case "right" -> {
                try {
                    doesExist = focusNode.rightNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }
            case "left" -> {
                try {
                    doesExist = focusNode.leftNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }

            case "parent" -> {
                try {
                    doesExist = focusNode.parNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }
            default -> throw new RuntimeException("неправильное название узла");

        }
    }

    public Node getMax() {
        Node focusNode = root;
        while (nodeExists(focusNode, "right")) {
            focusNode = focusNode.rightNode;
        }

        return focusNode;
    }

    

}
