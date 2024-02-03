package Les3;

public class ListUno {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node currentNode = new Node();
        currentNode.value = value;
        if (head == null) {
            head = currentNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = currentNode;
        }
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        } else {
            Node node = head;
            while (node.next != null) {
                if (node.next.next == null) {
                    node.next = null;
                    return;
                }
                node = node.next;
            }
        }
    }

    public void print() {
        Node node = head;
        System.out.print("[ ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("]");
    }

}
