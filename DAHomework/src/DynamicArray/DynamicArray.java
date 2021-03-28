package DynamicArray;


public class DynamicArray<A> {
    public A[] array;
    public int size = 0;

    public static String outOfBorderError = "Выход за границы массива";
    public static String cantFindElementError = "Данного элемента не существует";

    public DynamicArray(int actSize) {
        if (actSize < 1) {
            throw new RuntimeException(outOfBorderError);
        }
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

    public void addData(A value) {                    //Task 2 complete
    public void addData(A value) {
        resize(array.length + 1);
        array[array.length - 1] = value;
    }

    public int findFirst(A value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        throw new RuntimeException(cantFindElementError);
    }

    public int findLast(A value) {
        int lastind = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                lastind = i;
            }
        }
        if (lastind >= 0) {
            return lastind;
        }
        throw new RuntimeException(cantFindElementError);
    }

    public void remove(int index) {
        if (index < 0 || index > array.length) {
            throw new RuntimeException(outOfBorderError);
        }
        A[] newAr = (A[]) new Object[array.length - 1];
        for (int i = 0; i < index; i++) {
            newAr[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            newAr[i - 1] = array[i];
        }
        array = newAr;
    }

    public void insert(int index, A value) {
        if (index < 0 || index > array.length) {
            throw new RuntimeException(outOfBorderError);
        }
        resize(array.length + 1);
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i-1];
        }
        setData(index, value);
    }
}
