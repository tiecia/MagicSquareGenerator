import java.util.Arrays;

public class ClientTest {

    public static void main(String[] args) {
        Board b = new Board(3);
        System.out.println(b.checkValid(0, 0, 1));
        System.out.println(b.checkValid(1, 0, 2));
        System.out.println(b.checkValid(1, 1, 2));
        b.printBoard();
    }
}
