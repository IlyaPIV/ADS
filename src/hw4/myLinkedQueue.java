package hw4;

public class myLinkedQueue<E> implements myQueue<E> {

    private final myTwoSidedLinkedList<E> data;

    public myLinkedQueue(){
        this.data = new myTwoSidedLinkedList<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "myLinkedQueue { data="+data+" }";
    }
}
