package hw4;


public class myTest {
    public static void main(String[] args) {

        mySimpleLinkedList<Integer> mySLL = new mySimpleLinkedList<>();
        testSimpleLinkedList(mySLL);

        myLinkedListStack<Integer> myLLS = new myLinkedListStack<>();
        testLinkedListStack(myLLS);

        myTwoSidedLinkedList<Integer> myTSLL = new myTwoSidedLinkedList<>();
        testTwoSidedLinkedList(myTSLL);

        myLinkedQueue<Integer> myLQ = new myLinkedQueue<>();
        testLinkedQueue(myLQ);


        //ДОМАШНЕЕ ЗАДАНИЕ
        myLinkedDeque<Integer> myLDq = new myLinkedDeque<>();
        testLinkedDeque(myLDq);

        testIterator(mySLL);

    }

    public static void testSimpleLinkedList(mySimpleLinkedList<Integer> mySLL)
    {
        System.out.println("===== TEST mySimpleLinkedList ======");
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
    }

    public static void testLinkedListStack(myLinkedListStack<Integer> myLLS)
    {
        System.out.println();
        System.out.println("===== TEST myLinkedListStack ======");
        myLLS.push(1);
        myLLS.push(2);
        myLLS.push(3);
        myLLS.push(4);
        myLLS.push(5);

        myLLS.show();
    }

    public static void testTwoSidedLinkedList(myTwoSidedLinkedList<Integer> myTSLL)
    {
        System.out.println();
        System.out.println("===== TEST myTwoSidedLinkedList ======");

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

    }

    public static void testLinkedQueue(myLinkedQueue<Integer> myLQ)
    {

        System.out.println();
        System.out.println("===== TEST myLinkedQueue ======");

        myLQ.insert(1);
        myLQ.insert(2);
        myLQ.insert(3);
        myLQ.insert(4);
        myLQ.insert(5);

        System.out.println(myLQ.toString());
    }

    public static void testLinkedDeque(myLinkedDeque<Integer> myLDq)
    {
        System.out.println();
        System.out.println("===== TEST myLinkedDeque ======");

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
    }

    public static void testIterator(mySimpleLinkedList<Integer> mySLL)
    {
        myListIterator<Integer> myIterator = new myListIterator<>(mySLL);
        System.out.println();
        System.out.println("===== TEST myIterator ======");
        mySLL.display();
        System.out.println("Insert 4 after current:");
        myIterator.insertAfter(4);
        mySLL.display();
        System.out.println("Shift 1 point forward:");
        myIterator.nextLink();
        System.out.println(myIterator.showPosition());
        System.out.println("Delete current: ");
        myIterator.deleteCurrent();
        mySLL.display();
        System.out.println("Shift 1 point forward:");
        myIterator.nextLink();
    //    myIterator.nextLink();
        System.out.println(myIterator.showPosition());
        System.out.println("Insert 5 before current:");
        myIterator.insertBefore(5);
        mySLL.display();
        System.out.println("Reset iterator:");
        myIterator.reset();
        System.out.println(myIterator.showPosition());

        System.out.println("For-each:");
        for (Integer value:
             mySLL) {
            System.out.println(value);
        }
    }
}
