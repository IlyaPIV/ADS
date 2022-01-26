package hw4;

public class Node<E>{

        public E item;
        public Node<E> next;
        public Node<E> previous;

        public Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }

        public Node(E item, Node<E> next, Node<E> previous){
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

    @Override
    public String toString() {
        return item.toString();
    }
}
