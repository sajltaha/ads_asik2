package Stack;

import Lists.MyArrayList;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T topElement = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return topElement;
    }

    public void peek() {
        System.out.println(list.get(list.size() - 1));
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
        System.out.println(" ]");
    }
}