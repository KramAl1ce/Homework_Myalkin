package BinarySearchTree;

import java.util.Objects;

public class BinarySearchTree {
    public Node root;

//    public BinarySearchTree() {
//        root = new Node();
//    }

    public BinarySearchTree(String key) {
        root = new Node(key);
    }

//    public Node getRoot() {
//        return root;
//    }

    public void insert(String key) {
        if (root.key == null) {
            root = new Node(key);
            return;
        }
        balance(Objects.requireNonNull(insertRec(key, root)).parNode);
    }

    public Node search(String key) {
        return searchRec(key, root);
    }

    public Node getSuccessor(Node thisNode) {
        return getSuccessorRec(thisNode);
    }

    public Node getPredecessor(Node thisNode) {
        return getPredecessorRec(thisNode);
    }

    public void delete(Node thisNode) {
        Node HeadNode = deleteRec(thisNode);
    }

    public Node getMin() {
        Node thisNode = root;
        while (nodeExists(thisNode, "left")) {
            thisNode = thisNode.leftNode;
        }

        return thisNode;
    }

    public Node getMax() {
        Node thisNode = root;
        while (nodeExists(thisNode, "right")) {
            thisNode = thisNode.rightNode;
        }

        return thisNode;
    }

    private static Node insertRec(String key, Node thisNode) {
        if (key.compareTo(thisNode.key) > 0) {
            if (thisNode.rightNode == null) {
                return insertRec(key, thisNode.rightNode);
            } else {
                thisNode.rightNode = new Node(key);
                thisNode.rightNode.parNode = thisNode;
                return thisNode.rightNode;
            }
        } else if (key.compareTo(thisNode.key) <= 0) {
            if (thisNode.leftNode != null) {
                return insertRec(key, thisNode.leftNode);

            } else {
                thisNode.leftNode = new Node(key);
                thisNode.leftNode.parNode = thisNode;
                return thisNode.leftNode;
            }
        }
        return null;
    }

//    private Node deleteRec(Node thisNode, Node thisNodeParent, Node thisNodeChild) {
//        thisNodeParent = getPredecessor(thisNode);
//        thisNodeChild = getSuccessor(thisNode);
//        if (thisNode != null) {
//            return null;
//        }
//
//        boolean isLeftChild = false;
//        if (nodeExists(thisNodeParent, "left")) {
//            isLeftChild = thisNode == thisNodeParent.leftNode;
//        }
//
//        if (countChildren(thisNode) == 2) {
//
//            Node thisNodeSuccessor = getSuccessor(thisNode);
//            thisNodeSuccessor.leftNode = thisNode.leftNode;
//
//            if (isLeftChild) {
//                thisNodeParent.leftNode = thisNodeSuccessor;
//                thisNodeSuccessor.leftNode.parNode = thisNodeSuccessor;
//            } else {
//                thisNodeParent.rightNode = thisNodeSuccessor;
//                thisNodeSuccessor.rightNode.parNode = thisNodeSuccessor;
//            }
//
//            thisNodeSuccessor.parNode = thisNodeParent;
//            return thisNodeSuccessor;
//
//        }
//
//        else if (countChildren(thisNode) == 1) {
//
//            if (nodeExists(thisNode, "left")) {
//
//
//                Node newChild = thisNode.leftNode;
//                thisNode.leftNode.parNode = null;
//                if (isLeftChild) {
//                    thisNodeParent.leftNode = newChild;
//
//                    newChild.parNode = thisNodeParent;
//                    return thisNodeParent.leftNode;
//                } else {
//                    thisNodeParent.rightNode = newChild;
//
//                    newChild.parNode = thisNodeParent;
//                    return thisNodeParent.rightNode;
//                }
//
//            } else {
//
//                Node newChild = thisNode.rightNode;
//                thisNode.rightNode.parNode = null;
//                if (isLeftChild) {
//                    thisNodeParent.leftNode = newChild;
//
//                    newChild.parNode = thisNodeParent;
//                    return thisNodeParent.leftNode;
//                } else {
//                    thisNodeParent.rightNode = newChild;
//
//                    newChild.parNode = thisNodeParent;
//                    return thisNodeParent.rightNode;
//                }
//            }
//        }

    private Node deleteRec(Node thisNode) {

        if (thisNode.parNode == null) {
            thisNode.parNode = new Node();
            thisNode.parNode.leftNode = thisNode;
        }
        boolean isLeftChild = thisNode.parNode.leftNode == thisNode;

        if (thisNode.leftNode == null & thisNode.rightNode == null) {

            if (isLeftChild) {

                thisNode.parNode.leftNode = null;
            } else {

                thisNode.parNode.rightNode = null;
            }
            if (root.leftNode == null & root.rightNode == null) {

                root = null;
            }
        } else if (thisNode.leftNode != null & thisNode.rightNode == null) {

            if (isLeftChild) {
                thisNode.parNode.leftNode = thisNode.leftNode;
            } else {
                thisNode.parNode.rightNode = thisNode.leftNode;
            }

            thisNode.leftNode.parNode = thisNode.parNode;

            if (thisNode == root) {
                root = thisNode.leftNode;
            }
        } else if (thisNode.leftNode == null & thisNode.rightNode != null) {

            if (isLeftChild) {
                thisNode.parNode.leftNode = thisNode.rightNode;
            } else {
                thisNode.parNode.rightNode = thisNode.rightNode;
            }

            thisNode.rightNode.parNode = thisNode.parNode;

            if (thisNode == root) {
                root = thisNode.rightNode;
            }
        } else {
            Node successorNode = getSuccessor(thisNode);


            successorNode.parNode.leftNode = successorNode.rightNode;
            if (successorNode.rightNode != null) {
                successorNode.rightNode.parNode = successorNode.parNode;
            }

            successorNode.rightNode = thisNode.rightNode;
            thisNode.rightNode.parNode = successorNode;

            successorNode.parNode = thisNode.parNode;
            if (isLeftChild) {
                thisNode.parNode.leftNode = successorNode;
            } else {
                thisNode.parNode.rightNode = successorNode;
            }

            successorNode.leftNode = thisNode.leftNode;
            successorNode.leftNode.parNode = successorNode;

            thisNode.parNode = null;
            thisNode.leftNode = null;
            thisNode.rightNode = null;
            thisNode.key = null;

            if (root.key == null) {
                root = successorNode;
                root.parNode = null;
            }

            return successorNode;
        }

        return null;
    }

    private static Node searchRec(String key, Node thisNode) {
        if (thisNode == null) {
            return null;
        }
        if (key.equals(thisNode.key)) {
            return thisNode;
        }
        if (key.compareTo(thisNode.key) > 0) {
            return searchRec(key, thisNode.rightNode);
        }

        else if (key.compareTo(thisNode.key) < 0) {
            return searchRec(key, thisNode.leftNode);
        }
        return null;
    }

    private static Node getSuccessorRec(Node thisNode) {
        if (nodeExists(thisNode, "right")) {
            thisNode = thisNode.rightNode;
            while (thisNode.leftNode != null) {
                thisNode = thisNode.leftNode;
            }
            return thisNode;
        } else {
            while (nodeExists(thisNode, "parent")) {
                Node thisNodeParent = thisNode.parNode;
                if (thisNodeParent.leftNode == thisNode) {
                    return thisNodeParent;
                } else {
                    thisNode = thisNodeParent;
                }
            }
            return null;
        }
    }

    private static Node getPredecessorRec(Node thisNode) {
        if (nodeExists(thisNode, "left")) {
            thisNode = thisNode.leftNode;
            while (nodeExists(thisNode, "right")) {
                thisNode = thisNode.rightNode;
            }
            return thisNode;
        } else {

            while (nodeExists(thisNode, "parent")) {
                Node thisNodeParent = thisNode.parNode;
                if (thisNodeParent.rightNode == thisNode) {

                    return thisNodeParent;
                } else {
                    thisNode = thisNodeParent;
                }
            }
            return null;
        }
    }

    private static int countChildren(Node thisNode) {
        int count = 0;
        if (nodeExists(thisNode, "left")) {
            count++;
        }

        if (nodeExists(thisNode, "right")) {
            count++;
        }
        return count;
    }

    private static boolean nodeExists(Node thisNode, String whichNode) {
        boolean doesExist;

        switch (whichNode) {
            case "right" -> {
                try {
                    doesExist = thisNode.rightNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }
            case "left" -> {
                try {
                    doesExist = thisNode.leftNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }
            case "parent" -> {
                try {
                    doesExist = thisNode.parNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }

            default -> throw new RuntimeException("there is no such node");
        }
    }

//    AVL

    private Node getHighest() {
        Node firstNode = getMin();
        while (firstNode.parNode != null) {
            firstNode = firstNode.parNode;
        }

        return firstNode;
    }

    private Node rotateRight(Node focusNode) {
        Node parentNode = focusNode.parNode;
        Node leftChild = focusNode.leftNode;
        focusNode.leftNode = leftChild.rightNode;
        if (leftChild.rightNode != null) {
            leftChild.rightNode.parNode = leftChild;
        }

        leftChild.rightNode = focusNode;
        focusNode.parNode = leftChild;
        leftChild.parNode = parentNode;

        if (parentNode != null) {
            if (parentNode.leftNode == focusNode) {
                parentNode.leftNode = leftChild;
            } else {
                parentNode.rightNode = leftChild;
            }
        }

        root = getHighest();
        return leftChild;
    }

    private Node rotateLeft(Node focusNode) {
        Node parentNode = focusNode.parNode;
        Node rightChild = focusNode.rightNode;
        focusNode.rightNode = rightChild.leftNode;

        if (rightChild.rightNode != null) {
            rightChild.rightNode.parNode = rightChild;
        }

        rightChild.leftNode = focusNode;
        focusNode.parNode = rightChild;
        rightChild.parNode = parentNode;

        if (parentNode != null) {
            if (parentNode.leftNode == focusNode) {
                parentNode.leftNode = rightChild;
            } else {
                parentNode.rightNode = rightChild;
            }
        }

        root = getHighest();
        return rightChild;
    }

    public void balance(Node focusNode) {
        while (focusNode != null) {

            if (focusNode.getBalance() > 1) {

                if (focusNode.leftNode.getBalance() > 0) {

                    focusNode = rotateRight(focusNode);
                } else {

                    focusNode.leftNode = rotateLeft(focusNode.leftNode);
                    focusNode = rotateRight(focusNode);
                }
            }

            else if (focusNode.getBalance() < -1) {

                if (focusNode.rightNode.getBalance() < 0) {

                    focusNode = rotateLeft(focusNode);
                } else {

                    focusNode.rightNode = rotateRight(focusNode.rightNode);
                    focusNode = rotateLeft(focusNode);
                }
            }

            focusNode = focusNode.parNode;
        }
    }
}