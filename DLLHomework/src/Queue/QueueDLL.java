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

//    public void dequeue() {
//        DoubleLinkedListElement element = new DoubleLinkedListElement();
//
//        QDLL.setElementByNumber(0, element);
//        size--;
//    }
//    *не понятно почему, но getElementByNumber не видится системой, считается несуществующим
//    странно, особенно при условии полной работы setElementByNumber*


    public void printAll() {
        QDLL.printAll();
    }

}

