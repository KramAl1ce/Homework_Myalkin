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
        DoubleLinkedLists DLL = new DoubleLinkedLists();

        DLL.addTail(0);
        DLL.addTail(1);
        DLL.addTail(2);
        DLL.addTail(3);

//        assertEquals(3, DoubleLinkedLists.getValue(4));

    }

    @Test
    public void getSizeIfEmpty() {
        DoubleLinkedLists DLL = new DoubleLinkedLists();

        int actSize = DLL.getSize();
        assertEquals(0, actSize);
    }

    @Test
    public void getSizeIfFilled() {
        DoubleLinkedLists DLL= new DoubleLinkedLists();


        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);

        int actSize = DLL.getSize();
        assertEquals(3, actSize);
    }
}
