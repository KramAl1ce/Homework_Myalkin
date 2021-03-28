package DynamicArray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTests {
    @Test
    public void initializationOfDefSize() {
        DynamicArray array = new DynamicArray(15);
        assertEquals(array.size, array.getSize());
    }

    @Test
    public void sizeTest(){
        DynamicArray array = new DynamicArray(23);
        assertEquals(23, array.getSize());
    }

    @Test
    public void getSizeTest(){
        DynamicArray array = new DynamicArray(7);
        assertEquals(7, array.array.length);
    }

    @Test
    public void addDataTest(){
        DynamicArray array = new DynamicArray(1);
        array.addData(666);
        assertEquals(666, array.getData(1));
    }

    @Test
    public void insertByIndexTest() {
        DynamicArray array = new DynamicArray(1);
        array.setData(0, 4);
        array.insert(0, 7);
        assertEquals(1, array.findFirst(4));
    }

    @Test
    public void insertDataTest() {
        DynamicArray array = new DynamicArray(1);
        array.setData(0, 8);
        array.insert(0, 5);
        assertEquals(8, array.getData(1));
    }

    @Test
    public void findFirstTest(){
        DynamicArray array = new DynamicArray(5);
        for (int i = 0; i < array.getSize(); i++) {
            array.setData(i, "empty");
        }
        array.setData(1, 4);
        array.setData(2, 12);
        assertEquals(1, array.findFirst(4));
    }

    @Test
    public void findLastTest(){
        DynamicArray array = new DynamicArray(5);
        for (int i = 0; i < array.getSize(); i++){
            array.setData(i, "empty");
        }
        array.setData(1, 12);
        array.setData(2, 7);
        assertEquals(2, array.findLast(7));
    }

    @Test
    public void removeTest(){
        DynamicArray array = new DynamicArray(3);

        array.setData(0, 6);
        array.setData(1, 32);
        array.setData(2, 8);
        array.remove(1);

        assertEquals(2, array.getSize());
    }
}
