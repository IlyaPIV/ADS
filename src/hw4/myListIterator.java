package hw4;

import java.util.Iterator;

public class myListIterator<E> implements Iterator<E>{

        private Node<E> current;
        private Node<E> previous;
        private final mySimpleLinkedList<E> list;
        private int index = 0;


        public myListIterator(mySimpleLinkedList<E> list){

            this.list = list;
            this.reset();
        }

        public void reset(){
            this.current = list.getFirstLink();
            previous = null;
        }

        public boolean atEnd() { return this.current.next==null; }

        public void nextLink(){
            previous = current;
            current = current.next;
        }

        public Node<E> getCurrent(){
            return this.current;
        }

        public Node<E> getPrevious(){
            return this.previous;
        }

        public void insertAfter(E value){
            Node<E> newLink = new Node<>(value,current.next, previous);
            if (list.isEmpty()) {
                list.setFirstLink(newLink);
                current = newLink;
            } else {
                current.next.previous = newLink;
                current.next = newLink;
                nextLink();
            }
            list.size++;

        }

        public void insertBefore(E value){
            Node<E> newLink = new Node<>(value, current, previous);
            if (previous==null) {
                newLink.next = list.getFirstLink();
                list.setFirstLink(newLink);
            } else {
                previous.next = newLink;
                current.previous = newLink;
                current = newLink;
            }
            list.size++;

        }

        public E deleteCurrent(){
            E value = current.item;
            if (previous==null) {
                current.previous = null;
                list.setFirstLink(current.next);
                reset();
            } else {
                previous.next = current.next;
                if (atEnd()){
                    reset();
                } else {

                    current.next.previous = previous;
                    current = current.next;
                }
            }
            list.size--;

            return value;
        }

        public boolean hasNext() {
            return index< list.size;
        }


        public E next() {
            previous = current;
            current = current.next;
            index++;
            return previous.item;
        }

        public String showPosition(){
            if (current==null) return "List is empty. Null-point.";
            else
            {
                String pr = "";
                if (previous == null) pr = " null ";
                else pr = previous.toString();
                String cr = "";
                if (current.next == null) cr = " null ";
                else cr = current.next.toString();
                return "Current position = " + current.toString() + "; previous is = " + pr + "; next is = " + cr;
            }
        }


    @Override
    public String toString() {
        return current.toString();
    }


}
