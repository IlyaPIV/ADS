package hw4;


public class myTest {
    public static void main(String[] args) {
        System.out.println("===== TEST mySimpleLinkedList ======");
        mySimpleLinkedList<Integer> mySLL = new mySimpleLinkedList<>();

        //вставка
        mySLL.insertFirst(1);
        mySLL.insertFirst(2);
        mySLL.insertFirst(3);
        mySLL.insertFirst(2);
        mySLL.insertFirst(1);

        mySLL.display();

        //поиск
        System.out.println("Searching for 3: "+mySLL.contains(3));
        System.out.println("Searching for 5: "+mySLL.contains(5));
        System.out.println("Searching for 2: "+mySLL.contains(2));

        //получение первого
        System.out.println("Taking first: "+mySLL.getFirst());

        //удаление первого
        System.out.println("Removing first: "+mySLL.removeFirst());
        System.out.println("Taking first: "+mySLL.getFirst());

        mySLL.display();

        //удаление конкретного элемента
        System.out.println("Removing 3: ");
        mySLL.display();


        System.out.println();
        System.out.println("===== TEST mySimpleLinkedList ======");
        myLinkedListStack<Integer> myLLS = new myLinkedListStack<>();

        myLLS.push(1);
        myLLS.push(2);
        myLLS.push(3);
        myLLS.push(4);
        myLLS.push(5);

        myLLS.show();

        System.out.println();
        System.out.println("===== TEST myTwoSidedLinkedList ======");
        myTwoSidedLinkedList<Integer> myTSLL = new myTwoSidedLinkedList<>();
        //вставка
        myTSLL.insertFirst(1);
        myTSLL.insertFirst(2);
        myTSLL.insertFirst(3);
        myTSLL.insertLast(2);
        myTSLL.insertLast(3);
        myTSLL.display();

        //удаление конкретного элемента
        System.out.println("Removing 1: "+myTSLL.remove(1));
        myTSLL.display();
        System.out.println("Removing first: "+myTSLL.removeFirst());
        myTSLL.display();

        System.out.println();
        System.out.println("===== TEST myLinkedQueue ======");
        myLinkedQueue<Integer> myLQ = new myLinkedQueue<>();
        myLQ.insert(1);
        myLQ.insert(2);
        myLQ.insert(3);
        myLQ.insert(4);
        myLQ.insert(5);

        System.out.println(myLQ.toString());

        //ДОМАШНЕЕ ЗАДАНИЕ
        System.out.println();
        System.out.println("===== TEST myLinkedDeque ======");
        myLinkedDeque<Integer> myLDq = new myLinkedDeque<>();
        myLDq.pushFront(1);
        myLDq.pushFront(2);
        myLDq.pushFront(3);
        myLDq.pushBack(4);
        myLDq.pushBack(5);

        System.out.println(myLDq.toString());
        myLDq.displayFromFront();
        myLDq.displayFromBack();
        System.out.println("Last item is: "+myLDq.peekBack());
        System.out.println("First item is: "+myLDq.peekFront());
        System.out.println("Removing first item: "+myLDq.removeFirst());
        System.out.println("Removing first item: "+myLDq.removeFirst());
        System.out.println("Removing last item: "+myLDq.removeLast());

        System.out.println(myLDq.toString());

        System.out.println();
        System.out.println("===== TEST myIterator ======");
        myListIterator<Integer> myIterator = new myListIterator<>(mySLL);
        mySLL.display();
        System.out.println("Insert 4 after current:");
        myIterator.insertAfter(4);
        mySLL.display();
        myIterator.next();
        myIterator.next();
        myIterator.next();
        //System.out.println("Current position of iterator is: "+myIterator.getCurrent());
        System.out.println(myIterator.showPosition());
        System.out.println("Insert 5 before current:");
        myIterator.insertBefore(5);
        mySLL.display();
        System.out.println(myIterator.showPosition());
        myIterator.next();
        System.out.println("Удаляем текущий: ");
        myIterator.deleteCurrent();
        mySLL.display();



    }
}
