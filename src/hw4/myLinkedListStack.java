package hw4;

public class myLinkedListStack<E> implements myStack<E>{

    private final myLinkedListInterface<E> data;

    public myLinkedListStack(){
        this.data = new mySimpleLinkedList<E>();
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
        return data.getFirst();
    }

    @Override
    public E peek() {
        return data.removeFirst();
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
    public void show() {
        data.display();
    }

    @Override
    public String toString() {
        return "myLinkedListStack{ data= "+data+" }";
    }
}
