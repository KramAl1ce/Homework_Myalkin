package Stack;

import DoubleLinkedLists.DoubleLinkedLists;

public class StackDLL{
        DoubleLinkedLists<Integer> DLL = new DoubleLinkedLists<Integer>();
        int count = 0;

        public boolean isEmpty() {
            return DLL.isEmpty();
            }

        public void pushIn(int data) {
            DLL.addTail(data);
            count = count + 1;
        }

        public void popOut(int data) {
            DLL.popOut();
            count = count - 1;
        }

        public int getSize() {
            return  count;
        }


        public Object peek(){
            return DLL.getHead();
        }
}
