import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String playAgain = "";
    do {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameOver = false;
        while (!gameOver) {
        // Display the current state of the board
            System.out.println("   0  1  2");
            for (int row = 0; row < 3; row++) {
                System.out.print(row + " ");
                for (int col = 0; col < 3; col++) {
                    System.out.print(" " + board[row][col] + " ");
                    if (col < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (row < 2) {
                    System.out.println("  ---+---+---");
                }
            }
        // Prompt the current player to make a move
            System.out.println("Player " + currentPlayer + ", enter your move (row column):");
            System.out.print("enter row:");
            int row = input.nextInt();
            System.out.print("enter column:");
            int col = input.nextInt();
        // Check if the move is valid and update the board
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
          // Check if the game has been won
                if (checkWin(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (boardFull(board)) {
                    System.out.println("The game is a tie.");
                    gameOver = true;
                } else {
            // Switch to the other player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("That square is already occupied. Try again.");
            }
        }
      // Ask the players if they want to play again
        System.out.println("Do you want to play again? (Y/N)");
        playAgain = input.next();
    }
    while (playAgain.equalsIgnoreCase("Y"));
    }
  // Check if the game has been won by the current player
    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }   
        return false;
    }
// Check if the board is full
    public static boolean boardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {   
                    return false;
                }
            }
        }
        return true;    
    }
}
