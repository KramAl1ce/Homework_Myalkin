package BinarySearchTree;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = new Node();
    }

    public BinarySearchTree(String key) {
        root = new Node(key);
    }

    public void insert(String key) {
        if (root.key == null) {
            root = new Node(key);
            return;
        }
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

//    private static Node insertRec(String key, Node thisNode) {
//        if (key.compareTo(thisNode.key) > 0) {
//            if (thisNode.rightNode == null) {
//                return insertRec(key, thisNode.rightNode);
//            } else {
//                thisNode.rightNode = new Node(key);
//                thisNode.rightNode.parNode = thisNode;
//                return thisNode.rightNode;
//            }
//        } else if (key.compareTo(thisNode.key) <= 0) {
//            if (thisNode.leftNode != null) {
//                return insertRec(key, thisNode.leftNode);
//
//            } else {
//                thisNode.leftNode = new Node(key);
//                thisNode.leftNode.parNode = thisNode;
//                return thisNode.leftNode;
//            }
//        }
//        return null;
//    }
    public void delete(Node thisNode, Node thisNodeParent, Node thisNodeChild) {
        Node HeadNode = deleteRec(thisNode, thisNodeParent, thisNodeChild);
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

    private Node deleteRec(Node thisNode, Node thisNodeParent, Node thisNodeChild) {
        thisNodeParent = getPredecessor(thisNode);
        thisNodeChild = getSuccessor(thisNode);
        if (thisNode != null) {
            return null;
        }

        boolean isLeftChild = false;
        if (nodeExists(thisNodeParent, "left")) {
            isLeftChild = thisNode == thisNodeParent.leftNode;
        }

        if (countChildren(thisNode) == 2) {

            Node thisNodeSuccessor = getSuccessor(thisNode);
            thisNodeSuccessor.leftNode = thisNode.leftNode;

            if (isLeftChild) {
                thisNodeParent.leftNode = thisNodeSuccessor;
                thisNodeSuccessor.leftNode.parNode = thisNodeSuccessor;
            } else {
                thisNodeParent.rightNode = thisNodeSuccessor;
                thisNodeSuccessor.rightNode.parNode = thisNodeSuccessor;
            }

            thisNodeSuccessor.parNode = focusNodeParent;
            thisNodeSuccessor.parNode = thisNodeParent;
            return thisNodeSuccessor;

        }

        else if (countChildren(focusNode) == 1) {
        else if (countChildren(thisNode) == 1) {

            if (nodeExists(thisNode, "left")) {

            if (nodeExists(focusNode, "left")) {
                // if the node only has left child

                Node newChild = focusNode.leftNode; // copy new child
                focusNode.leftNode.parentNode = null; // delete focusNode from memory
                Node newChild = thisNode.leftNode;
                thisNode.leftNode.parNode = null;
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild; // link parent to child
                    thisNodeParent.leftNode = newChild;

                    newChild.parentNode = focusNodeParent; // link child to parent
                    return focusNodeParent.leftNode;
                    newChild.parNode = thisNodeParent;
                    return thisNodeParent.leftNode;
                } else {
                    focusNodeParent.rightNode = newChild;
                    thisNodeParent.rightNode = newChild;

                    newChild.parentNode = focusNodeParent; // link child to parent
                    return focusNodeParent.rightNode;
                    newChild.parNode = thisNodeParent;
                    return thisNodeParent.rightNode;
                }

            } else {
                // if the node only has right child

                Node newChild = focusNode.rightNode;
                focusNode.rightNode.parentNode = null;
                Node newChild = thisNode.rightNode;
                thisNode.rightNode.parNode = null;
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild;
                    thisNodeParent.leftNode = newChild;

                    newChild.parentNode = focusNodeParent;
                    return focusNodeParent.leftNode;
                    newChild.parNode = thisNodeParent;
                    return thisNodeParent.leftNode;
                } else {
                    focusNodeParent.rightNode = newChild;
                    thisNodeParent.rightNode = newChild;

                    newChild.parentNode = focusNodeParent;
                    return focusNodeParent.rightNode;
                    newChild.parNode = thisNodeParent;
                    return thisNodeParent.rightNode;
                }
            }
        }

        else if (countChildren(focusNode) == 0) {
        else if (countChildren(thisNode) == 0) {
            if (isLeftChild) {
                focusNodeParent.leftNode = null;
                return focusNodeParent;
                thisNodeParent.leftNode = null;
                return thisNodeParent;
            } else {
                focusNodeParent.rightNode = null;
                return focusNodeParent;
                thisNodeParent.rightNode = null;
                return thisNodeParent;
            }
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
                Node focusNodeParent = thisNode.parNode;
                if (focusNodeParent.leftNode == thisNode) {
                    return focusNodeParent;
                Node thisNodeParent = thisNode.parNode;
                if (thisNodeParent.leftNode == thisNode) {
                    return thisNodeParent;
                } else {
                    thisNode = focusNodeParent;
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
                Node focusNodeParent = thisNode.parNode;
                if (focusNodeParent.rightNode == thisNode) {
                Node thisNodeParent = thisNode.parNode;
                if (thisNodeParent.rightNode == thisNode) {

                    return focusNodeParent;
                    return thisNodeParent;
                } else {
                    thisNode = focusNodeParent;
                    thisNode = thisNodeParent;
                }
            }
            return null;
        }
    }

    private static int countChildren(Node focusNode) {
    private static int countChildren(Node thisNode) {
        int count = 0;
        if (nodeExists(focusNode, "left")) {
        if (nodeExists(thisNode, "left")) {
            count++;
        }

        if (nodeExists(focusNode, "right")) {
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
}