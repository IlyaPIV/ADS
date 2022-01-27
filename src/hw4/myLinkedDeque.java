package hw4;

public class myLinkedDeque<E> extends mySimpleLinkedList<E> implements myDeque<E> {

    private final myTwoSidedLinkedList<E> data;
    protected Node<E> last;

    public myLinkedDeque(){
        this.data = new myTwoSidedLinkedList<>();
    }

    @Override
    public void pushFront(E value) {
        Node<E> temp = first;
        first = new Node<>(value,first,null);
        size++;
        if (size==1) last = first;
            else temp.previous = first;
    }

    @Override
    public void pushBack(E value) {
        Node<E> temp = last;
        last = new Node<>(value, null, last);

        size++;
        if (size==1) first = last;
            else temp.next = last;
    }

    @Override
    public E removeFirst() {
        Node<E> temp = first.next;
        E value = first.item;
        temp.previous = null;
        first.next = null;
        first = temp;

        return value;
    }

    @Override
    public E removeLast() {
        Node<E> temp = last.previous;
        E value = last.item;
        temp.next = null;
        last.previous = null;
        last = temp;
        return value;
    }

    @Override
    public E peekFront() {
        return first.item;
    }

    @Override
    public E peekBack() {
        return last.item;
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
    public void displayFromFront() {
        StringBuilder sb = new StringBuilder(" <- ");
        Node<E> current = first;

        while (current!=null) {
            sb.append(current.item);
            if (current.next!=null) sb.append(" <-> ");
            current = current.next;
        }
        sb.append(" -> ");

        System.out.println("Deque from front: "+sb);
    }

    @Override
    public void displayFromBack() {
        StringBuilder sb = new StringBuilder(" <- ");
        Node<E> current = last;

        while (current!=null) {
            sb.append(current.item);
            if (current.previous!=null) sb.append(" <-> ");
            current = current.previous;
        }
        sb.append(" -> ");

        System.out.println("Deque from back: "+sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("myLinkedDeque data= { <- ");
        Node<E> current = first;

        while (current!=null) {
            sb.append(current.item);
            if (current.next!=null) sb.append(" <-> ");
            current = current.next;
        }
        sb.append(" -> }");
        return sb.toString();
    }
}
