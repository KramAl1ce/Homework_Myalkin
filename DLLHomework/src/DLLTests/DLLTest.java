package DLLTests;
import DoubleLinkedLists.DoubleLinkedLists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DLLTest extends Assertions {
    @Test
    public void addHeadTest() {
        DoubleLinkedLists<Integer> DLL = new DoubleLinkedLists<Integer>();

        DLL.addHead(666);

        assertEquals(666, DLL.getValue(0));
    }

    @Test
    public void addTailTest() {
        DoubleLinkedLists<Integer> DLL = new DoubleLinkedLists<Integer>();

        DLL.addTail(0);
        DLL.addTail(33);
        DLL.addTail(48);
        DLL.addTail(38);

        assertEquals(38, DLL.getValue(3));

    }

    @Test
    public void getSizeIfEmpty() {
        DoubleLinkedLists<Integer> DLL = new DoubleLinkedLists<Integer>();

        int actSize = DLL.getSize();
        assertEquals(0, actSize);
    }

    @Test
    public void getSizeIfFilled() {
        DoubleLinkedLists<Integer> DLL= new DoubleLinkedLists<Integer>();


        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);
        DLL.addTail(3);

        int actSize = DLL.getSize();
        assertEquals(3, actSize);
    }
}
