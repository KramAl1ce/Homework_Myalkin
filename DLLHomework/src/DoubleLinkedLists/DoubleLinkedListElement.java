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

        public void setNextEl(DoubleLinkedListElement next) {
            this.next = next;
        }

        public void setPrevEl(DoubleLinkedListElement previous) {
            this.previous = previous;
        }

        public DoubleLinkedListElement getNextEl() {
            return next;
        }

        public DoubleLinkedListElement getPrevEl() {
            return previous;
        }

        public void setData() {
            this.data = data;
        }
    }
