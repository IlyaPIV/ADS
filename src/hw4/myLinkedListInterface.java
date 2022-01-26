package hw4;

public interface myLinkedListInterface<E>{

    void insertFirst(E value);

    E getFirst();

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

//    class Node<E> {
//        E item;
//        Node<E> next;
//        Node<E> previous;
//
//        public Node(E item, Node<E> next){
//            this.item = item;
//            this.next = next;
//        }
//
//        public Node(E item, Node<E> next, Node<E> previous){
//            this.item = item;
//            this.next = next;
//            this.previous = previous;
//        }
//    }
}
