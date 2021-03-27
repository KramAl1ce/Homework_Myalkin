package DynamicArray;

public class DynamicArray<A> {
    public A[] array;
    public int size = 0;

    public DynamicArray() {
        array = (A[]) new Object[size];
    }

    public void resize(int actSize) {
        A[] newArray = (A[]) new Object[actSize]);
        int a = actSize;
        if (actSize > array.length) {
            a = array.length;
        }
        System.arraycopy(array, 0, newArray, 0, a);
        array = newArray;
    }
}
