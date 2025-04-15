import Lists.*;
import Stack.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================");

        System.out.println("\nTesting MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        System.out.println("Inserted: 5");
        arrayList.add(10);
        System.out.println("Inserted: 10");
        arrayList.add(15);
        System.out.println("Inserted: 15");
        arrayList.remove(1);
        System.out.println("Removed element at index 1");
        System.out.println("Element at index 1: " + arrayList.get(1));

        System.out.println("\n===============================================");

        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        System.out.println("Inserted: 10");
        linkedList.add(20);
        System.out.println("Inserted: 20");
        linkedList.add(30);
        System.out.println("Inserted: 30");
        linkedList.remove(1);
        System.out.println("Removed element at index 1");

        System.out.println("\n===============================================");

        System.out.println("\nTesting MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        System.out.println("Inserted: 100");
        stack.push(200);
        System.out.println("Inserted: 200");
        stack.push(300);
        System.out.println("Inserted: 300");
        System.out.println("Popped element: " + stack.pop());

        System.out.println("\n===============================================");

        System.out.println("\nTesting MyQueue:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        System.out.println("Inserted: 1");
        queue.enqueue(2);
        System.out.println("Inserted: 2");
        queue.enqueue(3);
        System.out.println("Inserted: 3");
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("\n===============================================");

        System.out.println("\nTesting MyMinHeap:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(50);
        System.out.println("Inserted 50");
        minHeap.insert(30);
        System.out.println("Inserted 30");
        minHeap.insert(20);
        System.out.println("Inserted 20");
        minHeap.insert(40);
        System.out.println("Inserted 40");
        System.out.println("Extracted min element: " + minHeap.extractMin());

        System.out.println("\n===============================================");
    }
}
