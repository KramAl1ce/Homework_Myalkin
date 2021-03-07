package DLLTests;
import DoubleLinkedLists.DoubleLinkedLists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DLLTest extends Assertions {
    @Test
    public void addHeadTest() {
        DoubleLinkedLists DoubleLinkedLists = new DoubleLinkedLists();
        DoubleLinkedLists.addHead(666);
        assertEquals(666, DoubleLinkedLists.getValue(0));
    }

    @Test
    public void addTailTest() {
//        DoubleLinkedLists.addTail(333);
    }

    @Test
    public void getSizeifEmpty() {
        DoubleLinkedLists DLL= new DoubleLinkedLists();


        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);

        int actSize = DLL.getSize();
        assertEquals(3, actSize);
    }
}
