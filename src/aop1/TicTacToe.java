package aop1;
public class TicTacToe {

    private char[][] board_array;
    private char presentPlayerMark;

    public TicTacToe() {
        board_array = new char[3][3];
        presentPlayerMark = 'x';
        SetupBoard();
    }

    //Gives us access to currentPlayerMark
    public char getmark()
    {
        return presentPlayerMark;
    }


    // Set/Reset the board back to all empty values.
    public void SetupBoard() {

        // Loop through rows
        for (int i = 0; i < 3; i++) {

            // Loop through columns
            for (int j = 0; j < 3; j++) {
                board_array[i][j] = '-';
            }
        }
    }




    
    // Print the current board (may be replaced by GUI implementation later)
    public void DisplayBoardCondition() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board_array[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean isPlayerWon() {
        return (rowWinnerFound() || columnWinnerFound() || diagonalPaternFound());
    }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean allSpaceFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board_array[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }
    
    // Loop through rows and see if any are winners.
    private boolean rowWinnerFound() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board_array[i][0], board_array[i][1], board_array[i][2]) == true) {
                return true;
            }
        }
        return false;
    }


    // Loop through columns and see if any are winners.
    private boolean columnWinnerFound() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board_array[0][i], board_array[1][i], board_array[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


   


    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }


    // Change player marks back and forth.
    public void changeturn() {
        if (presentPlayerMark == 'x') {
            presentPlayerMark = 'o';
        }
        else {
            presentPlayerMark = 'x';
        }
    }

    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean diagonalPaternFound() {
        return ((checkRowCol(board_array[0][0], board_array[1][1], board_array[2][2]) == true) || (checkRowCol(board_array[0][2], board_array[1][1], board_array[2][0]) == true));
    }
    
    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean markposition(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board_array[row][col] == '-') {
                    board_array[row][col] = presentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }
}