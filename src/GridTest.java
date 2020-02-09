public class GridTest {

    public static void main(String[] args) {

        int size = 3;
        int[][] board = new int[size][size];
        grid(board, size);

    }

    public static void grid(int[][] board, int size) {

        System.out.print("+");

        for (int i = 0; i < size; i++)
            System.out.print("\t―\t+");

        System.out.println();

        for (int[] array : board) {

            for (int num : array)
                System.out.print("|\t" + num + "\t");

            System.out.print("|\n+");

            for (int i = 0; i < size; i++)
                System.out.print("\t―\t+");

            System.out.println();

        }

    }

}