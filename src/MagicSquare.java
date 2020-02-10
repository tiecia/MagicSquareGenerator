import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MagicSquare {

    private Set<Board> boards = new HashSet<>();

    public void printAllBoards(int size){
        explore(0,0, new Board(size));
    }

    public void explore(int row, int col, Board board){
        if(col == board.size()){
            board.printBoard();
        } else {
            for(int n = 1; n<=Math.pow(board.size(), 2); n++){
                if(row == board.size()-1 && board.checkValid(row, col, n)) {
                    board.place(row, col, n);
                    explore(0,col+1, board);
                } else if(board.checkValid(row, col, n)){
                    board.place(row, col, n);
                    explore(row+1, col, board);
                }
                board.remove(row, col);
            }
        }
    }
}
