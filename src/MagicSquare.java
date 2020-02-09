public class MagicSquare {

    public static void printAllBoards(int size){
        explore(0, new Board(size));
    }

    public static void explore(int col, Board board){;
        System.out.println("explore");
        if(col == board.size()){
            board.printBoard();
        } else {
            for(int i = 0; i<board.size(); i++){ //Go through each row in the column
                for(int n = 1; n<Math.pow(board.size(), 2); n++){
                    if(col == board.size()-1 && board.checkValid(i, col, n)) {
                        explore(col+1, board);
                    } else if(board.checkValid(i, col, n)){
                        explore(col, board);
                    }
                    board.remove(i, col);
                }
            }
        }
    }
}
