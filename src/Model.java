public class Model {
    private char[][] board;

    public Model() {
        board = new char[15][15];
        emptyBoard();
    }

    /**
     * Empties the board or initializes the board to dashes
     */
    public void emptyBoard() {
        for (int i=0; i<15; i++) {
            for (int j=0; j<15; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void insertSymbol(int i, int j, int turn) {
        if (turn % 2 == 1) {
            board[i][j] = 'X';
        }
        else if (turn % 2 == 0) {
            board[i][j] = 'O';
        }
    }

    public boolean validMove(int i, int j) {
        if (board[i][j] != '-') {
            return false;
        }
        return true;
    }
}
