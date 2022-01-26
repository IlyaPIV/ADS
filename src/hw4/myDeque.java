package hw4;

public interface myDeque<E> {

    void pushFront(E value);

    void pushBack(E value);

    E removeFirst();

    E removeLast();

    E peekFront();

    E peekBack();

    int size();

    boolean isEmpty();

    boolean isFull();

    void displayFromFront();

    void displayFromBack();
}
