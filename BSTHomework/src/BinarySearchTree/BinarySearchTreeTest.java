package BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void insertionPositive() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвг");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("аб");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("а");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "абвгдёжзиклмно";
        String actual = tree.getSuccessor(tree.search("абвгдfghijk")).getKey();
        assertEquals(expected, actual);

        expected = "абвгдfghi";
        actual = tree.getSuccessor(tree.search("абвгдfgh")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void minFound() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "a";
        String actual = tree.getMin().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void maxFound() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "абвгдёжзиклмноqrst";
        String actual = tree.getMax().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsSuccessor() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "абвгдёжзиклмно";
        String actual = tree.getSuccessor(tree.search("абвгдfghijk")).getKey();
        assertEquals(expected, actual);

        expected = "абвгдfghi";
        actual = tree.getSuccessor(tree.search("абвгдfgh")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsNoSuccessor() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        Object expected = null;
        Object actual = tree.getSuccessor(tree.search("абвгдёжзиклмноqrst"));
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsPredecessor() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "абвгд";
        String actual = tree.getPredecessor(tree.search("абвгдfgh")).getKey();
        assertEquals(expected, actual);

        expected = "абвгдfghi";
        actual = tree.getPredecessor(tree.search("абвгдfghijk")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsNoPredecessor() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        Object expected = null;
        Object actual = tree.getPredecessor(tree.search("a"));
        assertEquals(expected, actual);
    }

    @Test
    public void insertionIfYes() {
        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмнопрст");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

//        tree.delete(tree.search("абвгдёжзиклмнопрст"));

        String expected = null;
        Object actual = tree.getSuccessor(tree.search("абвгдёжзиклмнопр"));
        assertEquals(expected, actual);
    }

    @Test
    public void searchingIfFound() {

        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвd");
        tree.insert("абвгдfghijk");
        tree.insert("абвгдfghi");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмноqrst");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмноqr");

        String expected = "абвd";
        String actual = tree.getSuccessor(tree.search("абв")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void searchingIfNotFound() {

        BinarySearchTree tree = new BinarySearchTree("абвгдfgh");
        tree.insert("абв");
        tree.insert("абвг");
        tree.insert("абвгдеёжзик");
        tree.insert("абвгдеёжз");
        tree.insert("ab");
        tree.insert("абвгдёжзиклмнопрст");
        tree.insert("абвгдёжзиклмноq");
        tree.insert("абвгд");
        tree.insert("a");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмнопр");

        Object expected = null;
        Object actual = tree.search("trhr");
        assertEquals(expected, actual);
    }

    @Test
    public void deletionIfNotFound() {

        BinarySearchTree tree = new BinarySearchTree("абвгдеёж");
        tree.insert("абв");
        tree.insert("абвг");
        tree.insert("абвгдеёжзи");
        tree.insert("абвгдеёжз");
        tree.insert("аб");
        tree.insert("абвгдёжзиклмнопрст");
        tree.insert("абвгдёжзиклмноп");
        tree.insert("абвгд");
        tree.insert("а");
        tree.insert("абвгдёжзиклмно");
        tree.insert("абвгдёжзиклмнопр");

        tree.delete(tree.search("прст"));

        String expected = "аб";
        String actual = tree.getSuccessor(tree.search("а")).getKey();
        assertEquals(expected, actual);
    }


}