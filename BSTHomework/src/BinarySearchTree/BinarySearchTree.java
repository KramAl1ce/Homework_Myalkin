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

    private static void insertRec(String key, Node focusNode) {
        if (key.compareTo(focusNode.num) > 0) {
            if (focusNode.rightNode == null) {
                focusNode.rightNode = new Node(key);
                focusNode.rightNode.parNode = focusNode;
                return;
            } else {
                insertRec(key, focusNode.rightNode);
            }
        }
        if (key.compareTo(focusNode.num) <= 0) {
            if (focusNode.leftNode == null) {
                focusNode.leftNode = new Node(key);
                focusNode.leftNode.parNode = focusNode;
            } else {
                insertRec(key, focusNode.leftNode);
            }
        }
    }

    public Node getSuccessor(Node focusNode) {
        return getSuccessorRec(focusNode);
    }

    private static Node getSuccessorRec(Node focusNode) {
        if (nodeExists(focusNode, "right")) {
            focusNode = focusNode.rightNode;
            while (focusNode.leftNode != null) {
                focusNode = focusNode.leftNode;
            }
            return focusNode;
        } else {
            while (nodeExists(focusNode, "parent")) {
                Node focusNodeParent = focusNode.parNode;
                if (focusNodeParent.leftNode == focusNode) {
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

    public static Node getPredecessor(Node focusNode) {
        if (nodeExists(focusNode, "left")) {
            focusNode = focusNode.leftNode;
            while (nodeExists(focusNode, "right")) {
                focusNode = focusNode.rightNode;
            }
            return focusNode;
        } else {
            // if left node doesn't exist

            while (nodeExists(focusNode, "parent")) {
                Node focusNodeParent = focusNode.parNode;
                if (focusNodeParent.rightNode == focusNode) {

                    return focusNodeParent;
                } else {
                    focusNode = focusNodeParent;
                }
            }
            return null;
        }
    }

    public Node search(String key) {
        return searchRec(key, root);
    }

    private static Node searchRec(String key, Node focusNode) {
        if (focusNode == null) {
            return null;
        }
        if (key.equals(focusNode.num)) {
            return focusNode;
        }
        if (key.compareTo(focusNode.num) > 0) {
            return searchRec(key, focusNode.rightNode);
        } else if (key.compareTo(focusNode.num) < 0) {
            return searchRec(key, focusNode.leftNode);
        }
        return null;
    }

    public Node getMin() {
        Node focusNode = root;
        while (nodeExists(focusNode, "left")) {
            focusNode = focusNode.leftNode;
        }
        return focusNode;
        }
        public Node getMax() {
        Node focusNode = root;
        while (nodeExists(focusNode, "right")) {
            focusNode = focusNode.rightNode;
        }
        return focusNode;
        }

    public void delete(String key) {
        Node focusNode = search(key);
        Node focusNodeParent = focusNode.parNode;
        boolean isLeftChild = false;
        if (nodeExists(focusNodeParent, "left")) {
            isLeftChild = key.equals(focusNodeParent.leftNode.num);
        }

        if (countChildren(focusNode) == 2) {
            //
        }

        if (countChildren(focusNode) == 1) {
            if (nodeExists(focusNode, "left")) {
                Node newChild = focusNode.leftNode;
                focusNode.leftNode.parNode = null;
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild;
                } else {
                    focusNodeParent.rightNode = newChild;
                }
                newChild.parNode = focusNodeParent;
            } else {
                Node newChild = focusNode.rightNode;
                focusNode.rightNode.parNode = null;
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild;
                } else {
                    focusNodeParent.rightNode = newChild;
                }
                newChild.parNode = focusNodeParent;
            }
        }
        else if (countChildren(focusNode) == 0) {
            if (isLeftChild) {
                focusNodeParent.leftNode = null;
            } else {
                focusNodeParent.rightNode = null;
            }
        }
    }
    private static int countChildren(Node focusNode) {
        int count = 0;
        if (nodeExists(focusNode, "left")) {
            count++;
        }
        if (nodeExists(focusNode, "right")) {
            count++;
        }
        return count;
    }

    public void printAll(boolean reversed) {
        reversed = !reversed;
        if (reversed) {
            printAllRec(getMax(), reversed);
        } else {
            printAllRec(getMin(), reversed);
        }
    }

    private static void printAllRec(Node focusNode, boolean reversed){
        if (focusNode == null) {
            return;
        }
        System.out.println(focusNode.num);
        Node nextNode;
        if (reversed) {
            nextNode = getPredecessor(focusNode);
        } else {
            nextNode = getSuccessorRec(focusNode);
        }
        printAllRec(nextNode, reversed);
    }

}
