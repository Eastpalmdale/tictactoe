import java.util.*;

public class TicTacToe {
    // helper methods

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];
    // board clearing to restart
    private static void clearBoard() {

        for (int row = 0; row < ROW; row++){

            for (int col = 0; col < COL; col++){

                board[row][col] = "-";

            }
        }
    }
    // starting board display
    private static void display() {

        for (int row = 0; row < ROW; row++){

            System.out.println("| ");
            for (int col = 0; col < COL; col++){

                System.out.print(board[row][col]+ " | ");

            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        // variables
        Scanner in = new Scanner(System.in);
        String playerMove = "o";
        boolean done;
        boolean loopExit;
        boolean gameOver;
        int moveCount = 0;

        do {
            // replay loop
            do {
                clearBoard();
                // gameplay loop
                do {

                    // board display
                    display();
                    // player
                    System.out.println("Player " + playerMove + " goes first");
                    // location decision
                    int rowMove = safeinput.getRangedInt(in, "Enter your move on the row. 1-3", 1, 3);
                    int colMove = safeinput.getRangedInt(in, "Enter your move on the col. 1-3", 1, 3);
                    rowMove--;
                    colMove--;
                    // checking if player is stupid (valid move or nah)
                    boolean moveValid = validPlayerMove(rowMove, colMove);

                    if (moveValid){
                        // recording how many moves have been made
                        moveCount ++;

                        board[rowMove][colMove] = playerMove;

                    }
                    // if player stupid (invalid) invalidate move
                    else {
                        if (playerMove.equals("x")) {

                            playerMove = "o";

                        } else {

                            playerMove = "x";

                        }
                    }

                    // tie or not
                    if (moveCount == 9){

                        System.out.println("This game has ended in a tie!");
                        gameOver = true;

                    }
                    // checking for win
                    gameOver = winCondition(playerMove);
                    // toggling team
                    if (playerMove.equals("x")) {
                        playerMove = "o";
                    } else {
                        playerMove = "x";
                    }

                } while (!gameOver);

                moveCount = 0;
                done = safeinput.getYNConfirm(in, "Wanna rematch? enter n for no or y for yes.");

            } while (!done);

            loopExit = safeinput.getYNConfirm(in, "Are you done playing? enter n for no or y for yes.");

            if (!loopExit) {
                clearBoard();
            }

        }while (!loopExit);

    }
    // overall win status
    private static boolean winCondition(String player){
        boolean rowWin = rowWinCondition(player);
        boolean colWin = colWinCondition(player);
        boolean diagonalWin = diagonalWinCondition(player);

        return rowWin || colWin || diagonalWin;
    }
    // checking if player made a proper move
    private static boolean validPlayerMove(int row, int col){
        boolean valid = false;

        if (board[row][col].equals("-")){
            valid = true;
        }
        else {
            System.out.println("That is an invalid place to move, pick somewhere else.");
        }

        return valid;
    }
    // col win check
    private static boolean colWinCondition(String player){
        boolean win = false;
        // refering to board
        if (board[0][0].equals(player)){
            if (board[0][1].equals(player)) {
                if (board[0][2].equals(player)){
                    win = true;
                    System.out.println("Column win");
                }
            }
        }
        else if (board[1][0].equals(player)){
            if (board[1][1].equals(player)) {
                if (board[1][2].equals(player)){
                    win = true;
                    System.out.println("Column win");
                }
            }
        }
        else if (board[2][0].equals(player)){
            if (board[2][1].equals(player)) {
                if (board[2][2].equals(player)){
                    win = true;
                    System.out.println("Column win");
                }
            }
        }
        return win;
    }
    // row win check
    private static boolean rowWinCondition(String player){
        boolean rowWin = false;

        if (board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)){
            rowWin = true;
            System.out.println("row win");
        }
        else if (board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)){
            rowWin = true;
            System.out.println("row win");
        }
        else if (board[0][2].equals(player) && board[2][2].equals(player) && board[1][2].equals(player)){
            rowWin = true;
            System.out.println("row win");
        }
        return rowWin;
    }
    // diagonal win check
    private static boolean diagonalWinCondition(String player){
        boolean win = false;

        if (board[0][0].equals(player)){
            if (board[1][1].equals(player)) {
                if (board[2][2].equals(player)){
                    win = true;
                    System.out.println("Diagonal win");
                }
            }
        }
        else if (board[0][2].equals(player) && board[2][0].equals(player)){
            if (board[1][1].equals(player)) {
                win = true;
                System.out.println("Diagonal win");
            }
        }
        return win;
    }

}
