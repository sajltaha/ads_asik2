package Lists;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    public void remove(int index) {
        checkIndex(index);
        MyNode node = getNode(index);
        removeNode(node);
    }

    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        removeNode(head);
    }

    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        removeNode(tail);
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void set(int index, T item) {
        checkIndex(index);
        getNode(index).data = item;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        MyNode current = getNode(index);
        MyNode newNode = new MyNode(element);

        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public int size() {
        return size;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public int indexOf(Object object) {
        int i = 0;
        for (MyNode curr = head; curr != null; curr = curr.next) {
            if (curr.data.equals(object)) return i;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (MyNode curr = tail; curr != null; curr = curr.prev) {
            if (curr.data.equals(object)) return i;
            i--;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode curr = head; curr != null; curr = curr.next) {
            array[i++] = curr.data;
        }
        return array;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public void sort() {
        if (size <= 1) return;
        Object[] array = toArray();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            current.data = (T) array[i];
            current = current.next;
        }
    }

    private MyNode getNode(int index) {
        MyNode curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr;
    }

    private void removeNode(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }
}