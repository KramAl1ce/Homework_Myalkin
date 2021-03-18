package DoubleLinkedLists;

import java.util.DuplicateFormatFlagsException;

public class DoubleLinkedLists<L> {
    private DoubleLinkedListElement<L> head;
    private DoubleLinkedListElement<L> tail;
    int size = 0;

    public static String outOfRangeError = "вне диапазона";
    public static String elementNotFoundError = "элемент отсутствует";
    public static String canNotPopOutError = "предыдущий элемент отсутствует";
    public static String listIsEmptyError = "список пустой";

    public DoubleLinkedLists() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addHead(L element) {
        DoubleLinkedListElement newElement = new DoubleLinkedListElement<>(element);
        newElement.next = head;
        newElement.previous = null;
        if (isEmpty()) head = tail = newElement;
        else  {
            head.previous = newElement;
            head = newElement;
            size = size + 1;
        }
    }

    public void addTail(L element) {
        DoubleLinkedListElement<L> newElement = new DoubleLinkedListElement<>(element);
        newElement.next = null;
        newElement.previous = tail;
        if (isEmpty())  head = tail = newElement;
        else {
            tail.next = newElement;
            tail = newElement;
            size = size + 1;
        }
    }

    public void popOut() {
        if (tail == null) {
            throw new RuntimeException(canNotPopOutError);
        }
        tail = tail.previous;
    }

    public L getValue(int number) {
        if (number < 0 || number > size) {
            throw new RuntimeException(outOfRangeError);
        }

        DoubleLinkedListElement<L> searcher = head;

        for (int currValue = 0; currValue < number; currValue++) {
            searcher = searcher.getNextEl();
        }

        return searcher.data;
    }

    public int getSize() {
        return size;
    }

    public DoubleLinkedListElement getElementByNumber(int number) {
        if  (number < 0 || number > size) {
            throw new RuntimeException(outOfRangeError);
        }
        DoubleLinkedListElement counter = head;

        for (int currNumber = 0; currNumber < number; currNumber++) {
            counter = counter.getNextEl();
        }
        return counter;
    }

    public void setElementByNumber(int number, DoubleLinkedListElement element) {
        if (number < 0 || number > size) {
            throw new RuntimeException(outOfRangeError);
        }

            DoubleLinkedListElement counter = head;

            for(int currNumber = 0; currNumber < number; currNumber++) {
                counter = counter.getNextEl();
            }

            if(counter.previous == null) {
                head = counter.next;
                return;
            }

            if(counter.next == null) {
                 tail = counter;
            }
            counter.previous.next = element;
    }

    public DoubleLinkedListElement<L> getTail() { return tail; }

    public DoubleLinkedListElement<L> getHead() {
        return head;
    }

    public void printList() {
        if (isEmpty()) {
            throw new RuntimeException(listIsEmptyError);
        }
        DoubleLinkedListElement counter = head;

        counter.setNextEl(head.getNextEl());

        while (counter.getNextEl() != null) {
            System.out.print(counter.getData() + ", ");
            counter = counter.getNextEl();
        }
        System.out.print(counter.getData());
    }

    public void printAll() {
        if (isEmpty()) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement iterator = head;
        iterator.setNextEl(head.getNextEl());

        while (iterator.getNextEl() != null) {
            System.out.print(iterator.getData() + " ");
            iterator = iterator.getNextEl();
        }
        System.out.println(iterator.getData());
    }

}
