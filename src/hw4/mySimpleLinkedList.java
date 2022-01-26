package hw4;

public class mySimpleLinkedList<E> implements myLinkedListInterface<E> {

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;

        Node<E> removedItem = first;
        first = first.next;
        removedItem.next = null;
        size--;

        return removedItem.item;
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

        previous.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {

        Node<E> current = first;

        while (current.next!=null){
            if (current.item.equals(value)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        Node<E> current = first;

        while (current!=null) {
            sb.append(current.item);
            if (current.next!=null) sb.append(" -> ");
            current = current.next;
        }
        sb.append(" }");
        return sb.toString();
    }

    public void setFirstLink(Node<E> value){
        this.first = value;
    }

    public Node<E> getFirstLink(){
        return first;
    }

    public myListIterator<E> getIterator(){
        return new myListIterator(this);
    }


}
