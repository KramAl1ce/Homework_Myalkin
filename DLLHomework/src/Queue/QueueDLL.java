package Queue;

import DoubleLinkedLists.*;

public class QueueDLL {
    DoubleLinkedLists QDLL = new DoubleLinkedLists();
    int size = 0;

    public int getSize() {
        return size;
    }

    public Object peek() {
        return QDLL.getHead().getData();
    }

    public void enqueue(int data) {
        QDLL.addTail(data);
        size = size + 1;
    }

    public void dequeue(int data) {
        DoubleLinkedListElement element = new QDLL.getElementByNumber(data);

        QDLL.setElementByNumber(0, element);
        size--;
    }

    public void printAll() {
        QDLL.printAll();
    }
}
