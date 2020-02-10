public class MagicSquare {

    private StringBuilder boardList = new StringBuilder();

    public void printAllBoards(int size){
        explore(0,0, new Board(size));
        System.out.println(boardList);
    }

    public void explore(int row, int col, Board board){
        if(col == board.size()){
            boardList.append(board.getBoardAsString());
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
