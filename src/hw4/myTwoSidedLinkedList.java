package hw4;

public class myTwoSidedLinkedList<E> extends mySimpleLinkedList<E> implements myTwoSidedLinkedListInterface<E>{

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size==1) last = first;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<E> newElement = new Node<>(value, null);
        last.next = newElement;
        last = newElement;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            last=null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> previous = null;

        while (current.next!=null){
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current==null) {
            return false;
        }

        if (current==first) {
            removeFirst();
            return true;
        }

        if (current==last){
            last = previous;
            last.next = null;
        }

        previous.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E returnLast() {
        return last.item;
    }

}
