package Les3;

public class ListDuo {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    public void revert () {
        Node currentNode = head;
        while (currentNode != null) {
            Node previous = currentNode.previous;
            Node next = currentNode.next;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
            
        }


    }
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            head.previous = node;
            node.next = head;
        } 
        else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            tail = null;
            head = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            tail.next = node;
            node.previous = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            tail = null;
            head = null;
        }
    }

    public void sort() {
        Node node = head;
        while (node.next != null) {
            Node minNode = node;
            Node tempNode = node.next;
            while (tempNode != null) {
                if (tempNode.value < minNode.value) {
                    minNode = tempNode;
                }
                tempNode = tempNode.next;
            }

            if (minNode != node) {
                swap(node, minNode);
                
                if (minNode.previous == null) {
                    head = minNode;
                }
                if (node.next == null) {
                    tail = node;
                }
                node = minNode.next;
            }
            node = node.next;
        }
    }

    private void swap(Node node1, Node node2) {
        Node temp = node1.previous;
        node1.previous = node2.previous;
        node2.previous = temp;
        temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;

        if (node2.previous != null) {
            node2.previous.next = node2;
        }
        if (node2.next != null) {
            node2.next.previous = node2;
        }
        if (node1.previous != null) {
            node1.previous.next = node1;
        }
        if (node1.next != null) {
            node1.next.previous = node1;
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
