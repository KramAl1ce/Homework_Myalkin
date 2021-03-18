package Stack;
import DoubleLinkedLists.DoubleLinkedLists;
import Stack.StackDLL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SDLLTests extends Assertions {
    @Test
    public void peekTest() {
        StackDLL SDLL = new StackDLL();

        assertEquals(1, SDLL.peek());
    }

//    @Test

}
