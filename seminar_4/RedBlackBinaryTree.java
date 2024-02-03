public class RedBlackBinaryTree<E extends Comparable<E>> {

    private Node root;

    private class Node {
        private E value;
        private Node left;
        private Node right;
        private Color color;

        @Override
        public String toString() {
            return "Node{" +
                    "value = " + value +
                    ", color = " + color +
                    "}";
    
        }
    }

    private enum Color {
        RED, BLACK;
    }

    public boolean contains (E value) {
        Node node = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        return false;
    }

    public boolean add (E value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
        else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode (Node node, E value) {
        if (node.value == value) {
            return false;
        }
        else {
            if (node.value.compareTo(value) > 0) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                }
                else {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                    return true;
                }
            }
            else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                }
                else {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                    return true;
                }
            }
        }
    }

    private void colorSwap (Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap (Node node) {
        Node leftChild = node.left;
        Node betweenChild = node.left.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rightSwap (Node node) {
        Node rightChild = node.right;
        Node betweenChild = node.right.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node rebalance (Node node) {
        Node result = node;
        boolean needToRebalance;
        do {
            needToRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needToRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needToRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needToRebalance = true;
                colorSwap(result);
            }
        }
        while (needToRebalance);
        return result;
    }
}
