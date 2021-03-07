package DoubleLinkedLists;

public class DoubleLinkedLists<L> {
    private DoubleLinkedListElement head;
    private DoubleLinkedListElement tail;
    int size = 0;

    public static String outOfRangeError = "вне диапазона";
    public static String elementNotFoundError = "элемент отсутствует";


    public DoubleLinkedLists() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addHead(L element) {
        DoubleLinkedListElement<L> newElement = new DoubleLinkedListElement<L>(element);
        newElement.next = head;
        newElement.previous = null;
        if (isEmpty()) head = tail = newElement;
        else  {
            head.previous = newElement;
            head = newElement;
            size = size + 1;
        }
    }

    public L getValue(int number) {
        if (number<0 || number > size) {
            throw new RuntimeException(outOfRangeError);
        }

        DoubleLinkedListElement searcher = head;

        for (int currValue = 0; currValue < number; currValue++) {
            searcher = searcher.getNextElement();
        }

        return (L) searcher.data;
    }

    public int getSize() {
        return size;
    }

    public void addTail(L element) {
        DoubleLinkedListElement<L> newElement = new DoubleLinkedListElement(element);
        newElement.next = null;
        newElement.previous = tail;
        if (isEmpty())  head = tail = newElement;
        else {
            tail.next = newElement;
            tail = newElement;
            size = size + 1;
        }
    }

    public void getTail() {
    }

    public void getHead(L element) {

    }
}
