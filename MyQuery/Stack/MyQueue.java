package Stack;

import Lists.MyLinkedList;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T element) {
        list.addLast(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        list.remove(0);
        return list.getFirst();
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(list.getFirst());
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
        System.out.println(" ]");
    }
}
