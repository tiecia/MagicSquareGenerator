import java.util.Arrays;

public class Board {

    private int sum;

    private int[][] board;

    public Board(int size){
        if(size < 3){
            throw new IllegalArgumentException("Size Too Small");
        }
        this.sum = (int)(Math.pow(size, 3) + size)/2;
        this.board = new int[size][size];
    }

    public boolean checkValid(int row, int col, int num){
        if(board[row][col] != 0){
            return false;
        }
        if(contains(num)){
            return false;
        }
        if(!checkNegDiag(row, col, num) || !checkPosDiag(row, col, num)){
            return false;
        }
        if(!isRowValid(row, col, num) || !isColumnValid(row, col, num)){
            return false;
        }
        board[row][col] = num;
        return true;
    }

    public void place(int row, int col, int num){
        board[row][col] = num;
    }

    private boolean contains(int num){
        for(int[] arr : board){
            for(int current : arr){
                if(num == current){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRowValid(int row, int col, int num){
        int sum = 0;
        for(int currentNum : board[row]) {
            sum += currentNum;
        }
        sum += num;
        if(col == board.length-1 && sum != this.sum ) { //Dead end for row not adding up
            return false;
        }
        return sum <= this.sum;
    }

    private boolean isColumnValid(int row, int col, int num){
        int sum = 0;
        for(int[] arr : board){
            sum += arr[col];
        }
        sum+= num;
        if(row == board.length-1 && sum != this.sum){ //Dead end for column not adding up
            return false;
        }
        return sum <= this.sum;
    }

    //Return true if number can be placed there or if input is not on a diag
    //Return false is number cannot be placed there
    private boolean checkNegDiag(int row, int col, int num){
        if(row != col){
            return true;
        }
        int sum = 0;
        for(int i = 0; i<board.length; i++){
            sum += board[i][i];
        }
        if(row == board.length-1 && sum+num != this.sum){
            return false;
        }
        return sum <= this.sum;
    }

    private boolean checkPosDiag(int row, int col, int num){
        if(row+col != board.length){ //Dead end for if point is on of this diag
            return true;
        }
        int sum = 0;
        int n = board.length-1;
        for(int i = 0; i<board.length; i++){
            sum += board[i][n];
            if(row == 0 && sum+num != this.sum){  //TODO if number is placed in row 0 this will always be triggered off.
                return false;
            }
            n--;
        }
        return sum <= this.sum;
    }

    public void remove(int row, int col){
        board[row][col] = 0;
    }

    public int size(){
        return board.length;
    }

    public void printBoard(){
        for(int[] list : board){
            System.out.println(Arrays.toString(list));
        }
        System.out.println();
    }
}
