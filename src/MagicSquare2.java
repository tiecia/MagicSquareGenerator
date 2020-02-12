import java.util.*;
import java.io.*;

public class MagicSquare2 {

    private int[][] board;
    private int magicConstant;
    private int size;
    private FileOutputStream output;
    private int efficiency;

    public MagicSquare2(int size) throws FileNotFoundException {

        if (size < 3)
            throw new IllegalArgumentException("dimensions too small");

        this.board = new int[size][size];
        this.magicConstant = (int) (Math.pow(size, 3) + size) / 2;
        this.size = size;
        this.output = new FileOutputStream(size + " sided solutions.txt");

    }

    public int size() {

        return this.size;

    }

    public int magicConstant() {

        return this.magicConstant;

    }

    public void solve() throws FileNotFoundException {

        PrintStream print = new PrintStream(this.output);
        print.println("Magic Constant: " + this.magicConstant + "\n");

        explore(0, 0);

    }

    private void explore(int row, int col) throws FileNotFoundException {

        this.efficiency++;
        System.out.println(this.efficiency);


        if (col == size) {

            print();

        } else {

            for (int n = 1; n <= (int) Math.pow(this.size, 2); n++) {

                if (isSafe(row, col, n)) {

                    place(row, col, n);

                    if (row != this.size - 1)
                        explore(row + 1, col);
                    else
                        explore(0, col + 1);

                    remove(row, col);

                }

            }

        }

    }

    private boolean isSafe(int row, int col, int num) {

        if (board[row][col] > 0 || contains(num) || !checkTopDiag(row, col, num)
                || !checkBotDiag(row, col, num)) {

            return false;

        } else {

            return checkRow(row, col, num) && checkColumn(row, col, num);

        }

    }

    private boolean checkRow(int row, int col, int num) {

        int sum = 0;

        for (int value : this.board[row]) {

            sum += value;

            if (sum > this.magicConstant)
                return false;

        }

        sum += num;

        if (col == size - 1 && sum != this.magicConstant)
            return false;

        return sum <= this.magicConstant;

    }

    private boolean checkColumn(int row, int col, int num) {

        int sum = 0;

        for (int[] array : this.board) {

            sum += array[col];

            if (sum > this.magicConstant)
                return false;

        }

        sum += num;

        if (row == this.size - 1 && sum != this.magicConstant)
            return false;

        return sum <= this.magicConstant;

    }

    private boolean checkTopDiag(int row, int col, int num) {

        if (row != col)
            return true;

        int sum = 0;

        for (int i = 0; i < this.size; i++) {

            sum += this.board[i][i];

            if (sum > this.magicConstant)
                return false;

        }

        if (row == this.size - 1 && sum + num != this.magicConstant)
            return false;

        return sum <= this.magicConstant;

    }

    private boolean checkBotDiag(int row, int col, int num) {

        if (row + col != this.size - 1)
            return true;

        int sum = 0;
        int n = this.size - 1;

        for (int i = 0; i < this.size; i++) {

            sum += this.board[n][i];

            if (sum > this.magicConstant)
                return false;

            n--;

        }

        if(col == this.size - 1 && sum + num != this.magicConstant)
            return false;

        return sum <= this.magicConstant;

    }

    private boolean contains(int num) {

        for (int[] array : this.board)
            for (int value : array)
                if (value == num)
                    return true;

        return false;

    }

    private void place(int row, int col, int num) {

        this.board[row][col] = num;

    }

    private void remove(int row, int col) {

        this.board[row][col] = 0;

    }

    private void print() throws FileNotFoundException {

        PrintStream print = new PrintStream(this.output);

        for (int[] array : this.board)
            print.println(Arrays.toString(array));

        print.println();

    }

}