package Queue;
import DoubleLinkedLists.DoubleLinkedLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QDLLTests extends Assertions {

    @Test
    public void printAllTest() {
        QueueDLL QDLL = new QueueDLL();

        QDLL.enqueue(15);
        QDLL.enqueue(7);
        QDLL.enqueue(8);
        QDLL.enqueue(333);
        QDLL.enqueue(65);
        QDLL.enqueue(85);

        QDLL.printAll();
    }

    @Test
    public void enqueueTest() {
        QueueDLL QDLL = new QueueDLL();

        QDLL.enqueue(15);
        QDLL.enqueue(7);
        QDLL.enqueue(8);

        assertEquals(15, QDLL.peek());
        assertEquals(3, QDLL.getSize());
    }

    @Test
    public void dequeueTest() {
        QueueDLL QDLL = new QueueDLL();

        QDLL.enqueue(333);
        QDLL.enqueue(65);
        QDLL.enqueue(85);

        QDLL.dequeue();

        assertEquals(65, QDLL.peek());
        assertEquals(2, QDLL.getSize());
    }
}