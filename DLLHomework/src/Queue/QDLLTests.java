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

    
}