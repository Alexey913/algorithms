public class HashTable<T, K> {

    private static final int BASKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size = 0;

    private ListForHash<T, K>[] baskets;

    public K get(T key) {
        int index = calculateIndex(key);
        ListForHash<T, K> list = baskets[index];
        if (list != null) {
            return list.find(key);
        }
        return null;
    }

    private void recalculate() {
        ListForHash<T, K>[] old = baskets;
        baskets = (ListForHash<T, K>[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            ListForHash<T, K> temp = old[i];
            ListForHash<T, K>.Node node = temp.head;
            while (node != null) {
                put((T) node.entity.key, (K) node.entity.value);
                node = node.next;
            }

        }
    }

    private int calculateIndex(T key) {
        int hashCode = key.hashCode();
        int basketIndex = Math.abs(hashCode) % baskets.length;
        return basketIndex;
    }

    public HashTable(int size, HashTable<T, K>.ListForHash<T, K>[] baskets) {
        this.size = size;
        this.baskets = baskets;
    }

    public HashTable(int size) {
        baskets = (ListForHash<T, K>[]) new Object[size];
    }

    public HashTable() {
        this(BASKET_COUNT);
    }

    public boolean put(T key, K value) {
        if (baskets.length * LOAD_FACTOR < size) {
            recalculate();
        }
        int index = calculateIndex(key);
        ListForHash<T, K> list = baskets[index];
        if (list == null) {
            list = new ListForHash<>();
            baskets[index] = list;
        }
        Entity<T, K> entity = new Entity<>();
        entity.key = key;
        entity.value = value;
        boolean add = list.add(entity);
        if (add)
            size++;
        return add;
    }

    public boolean remove(T key) {
        int index = calculateIndex(key);
        ListForHash<T, K> list = baskets[index];
        boolean del = list.remove(key);
        if (del)
            size--;
        return del;
    }

    private class ListForHash<T, K> {
        Node head;

        public K find(T key) {
            Node node = head;
            while (node != null) {
                if (node.entity.key.equals(key)) {
                    return node.entity.value;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

        public boolean add(Entity<T,K> entity) {
            Node node = new Node();
            node.entity = entity;
            if (head != null) {
                Node currentNode = head;
                while (currentNode != null) {
                    if (currentNode.entity.equals(entity)) {
                        return false;
                    }
                    if (currentNode.next == null) {
                        currentNode.next = node;
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            } else {
                node = head;
            }
            return true;
        }

        public boolean remove(T key) {
            if (head != null) {
                if (head.entity.key.equals(key)) {
                    head = head.next;
                    return true;
                } else {
                    Node currentNode = head;
                    while (currentNode.next != null) {
                        if (currentNode.next.entity.key.equals(key)) {
                            currentNode.next = currentNode.next.next;
                            return true;
                        } else {
                            currentNode = currentNode.next;
                        }
                    }
                }
            }
            return false;
        }

        private class Node {
            Node next;
            Entity<T, K> entity;
        }
    }

    private class Entity<T, K> {
        T key;
        K value;
    }
}
