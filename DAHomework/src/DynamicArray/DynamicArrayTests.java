package DynamicArray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTests {
    @Test
    public void init_sizeDefault() {
        DynamicArray array = new DynamicArray(10);
        assertEquals(array.size, array.getSize());
    }

    @Test
    public void testSize(){
        DynamicArray array = new DynamicArray(25);
        assertEquals(25, array.getSize());
    }

    @Test
    public void testGetSize(){
        DynamicArray array = new DynamicArray(45);
        assertEquals(45, array.array.length);
    }

    @Test
    public void testAddData(){
        DynamicArray array = new DynamicArray(1);
        array.addData(345);
        assertEquals(345, array.getData(1));
    }
}
