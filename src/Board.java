import com.sun.javaws.exceptions.InvalidArgumentException;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Board {

    private int size;
    private int sum;

    private int[][] board;

    public Board(int size){
        if(size < 3){
            throw new IllegalArgumentException("Size Too Small");
        }
        this.size = size;
        this.sum = (int)(Math.pow(size, 3) + size)/2;
        this.board = new int[size][size];
    }

    public boolean checkValid(int row, int col, int num){
        if(board[row][col] != 0){
            return false;
        }
        for(int[] rowList : board) {
            int[] sorted = rowList.clone();
            Arrays.sort(sorted);
            System.out.println(Arrays.toString(sorted));
            if (Arrays.binarySearch(sorted, num) < 0) {
                return false;
            }
        }
        if(row == col && !checkDiag()){
            return false;
        }
        if(!checkRow(row) || !checkColumn(col)){
            return false;
        }
        board[row][col] = num;
        return true;
    }

//    public void place(int row, int col, int num, int nu1){
//        board[row][col] = num;
//    }

    private boolean checkRow(int row){
        int sum = 0;
        for(int num : board[row]){
            sum += num;
        }
        return sum <= this.sum;
    }

    private boolean checkColumn(int col){
        return true;
    }

    private boolean checkDiag(){
        return true;
    }

    public void place(int row, int col, int num){

    }

    public void remove(int row, int col){
        board[row][col] = 0;
    }

    public void printBoard(){
        for(int[] list : board){
            System.out.println(Arrays.toString(list));
        }
    }
}
