package DoubleLinkedLists;

    public class DoubleLinkedListElement<L> {
        L data;
        DoubleLinkedListElement<L> previous, next;
        DoubleLinkedListElement(L data) {
            this.data = data;
        }


        public DoubleLinkedListElement getNextElement() {
            return next;
        }

        public L getData() {
            return data;
        }
    }
