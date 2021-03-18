package Queue;

import DoubleLinkedLists.*;

public class QueueDLL {
    DoubleLinkedLists<Integer> QDLL = new DoubleLinkedLists<Integer>();
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

    public void dequeue() {

    }
}
