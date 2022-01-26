package hw4;

public class myListIterator<E> {

        private Node<E> current;
        private Node<E> previous;
        private final mySimpleLinkedList<E> list;

        public myListIterator(mySimpleLinkedList<E> list){

            this.list = list;
            this.reset();
        }

        public void reset(){
            this.current = list.getFirstLink();
            previous = null;
        }

        public boolean atEnd() { return this.current==null; }

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

            return value;
        }

        public boolean hasNext() {
            return current.next!=null;
        }


        public Node<E> next() {
            return current.next;
        }

        public String showPosition(){
            return "Current position = "+current.toString()+"; previous is = "+previous.toString()
                    +"; next is = "+current.next.toString();
        }

    @Override
    public String toString() {
        return current.toString();
    }
}
