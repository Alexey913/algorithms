public class BinaryTree<E extends Comparable<E>> {

    private Node root;

    private class Node {
        private E value;
        private Node left;
        private Node right;
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

    public void add (E value) {
        Node node = root;
        Node newNode = new Node();
        newNode.value = value;
        if (root != null) {
            if (node.value.compareTo(value) > 0) {
                node.left = newNode;
            }
            else {
                node.right = newNode;
            }
        }
        else {
            root = newNode;
        }
    }
}
