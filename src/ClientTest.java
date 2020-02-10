import java.util.Arrays;

public class ClientTest {

    public static void main(String[] args) {
        int size = 3;
        System.out.println("Magic Constant: " + (int)(Math.pow(size, 3) + size)/2 + "\n");
        MagicSquare square = new MagicSquare();
        square.printAllBoards(size);
    }
}
