package Lists;

public interface MyList<T> extends Iterable<T> {
    void add(T element);

    void set(int index, T element);

    void add(int index, T element);

    void addFirst(T element);

    void addLast(T element);

    T get(int index);

    T getFirst();

    T getLast();

    void remove(int index);

    void removeFirst();

    void removeLast();

    void sort();

    int indexOf(Object object);

    int lastIndexOf(Object object);

    boolean exists(Object object);

    public Object[] toArray();

    void clear();

    int size();
}