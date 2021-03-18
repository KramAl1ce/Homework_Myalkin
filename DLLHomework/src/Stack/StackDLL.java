package Stack;

import DoubleLinkedLists.DoubleLinkedLists;

public class StackDLL{
        DoubleLinkedLists<Integer> SDLL = new DoubleLinkedLists<Integer>();
        int count = 0;

        public boolean isEmpty() {
            return count==0;
            }

        public void pushIn(int data) {
            SDLL.addTail(data);
            count = count + 1;
        }

        public void popOut(int data) {
            SDLL.popOut();
            count = count - 1;
        }

        public int getSize() {
            return count;
        }


        public Object peek(){
            return SDLL.getHead().getData();
        }

        public void printStack() {
            SDLL.printList();
        }
}
