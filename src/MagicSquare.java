public class MagicSquare {

    public static void printAllBoards(int size){

        explore(0, new Board(size));

    }

    public static void explore(int col, Board board) {

        System.out.println("explore");
        board.printBoard();

        if (col == board.size()) {

            System.out.println("SOLUTION:");
            board.printBoard();

        } else {

            for (int i = 0; i < board.size(); i++){ //Go through each row in the column

                for (int n = 1; n <= (int)Math.pow(board.size(), 2); n++) {

                    if (board.checkValid(i, col, n)) {

                        if (col == board.size()-1) {
                            explore(col+1, board);
                        } else {
                            explore(col, board);
                        }

                        board.remove(i, col);

                    }

                }

            }

        }

    }

}
