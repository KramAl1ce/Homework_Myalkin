package DynamicArray;

public class DynamicArray<A> {
    public A[] array;
    public int size = 0;

    public static String outOfBorderError = "Выход за границы массива";

    public DynamicArray() {
        array = (A[]) new Object[size];
    }

    public void resize(int actSize) {
        A[] newArray = (A[]) new Object[actSize];
        int a = actSize;
        if (actSize > array.length) {
            a = array.length;
        }
        System.arraycopy(array, 0, newArray, 0, a);
        array = newArray;
    }

    public A getData(int number) {
        if (array.length < number || number < 0) {
            throw new RuntimeException(outOfBorderError);
        }
        return array[number];
    }

    public void setData(int number, A value) {
        if (number < 0 || number > array.length) {
            throw new RuntimeException(outOfBorderError);
        }
        array[number] = value;
    }

    public int getSize() {
        return array.length;
    }


}
