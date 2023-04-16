//Pranav Saran
//Period 4

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board =
                {{"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}};
        display(board); //first display
        //counters/determiners
        int game = 0;
        int turn = 1;
        int input;

        while (game == 0) {
            if (turn % 2 == 1) {
                System.out.println("Player 1's turn (X)");
            } else {
                System.out.println("Player 2's turn (O)");
            }
            input = sc.nextInt();
            sc.nextLine();
            //changing board slots
            if (input == 1) { //a1
                if (turn % 2 == 1) {
                    board[0][0] = "X";
                } else {
                    board[0][0] = "O";
                }
            }
            if (input == 2) { //a2
                if (turn % 2 == 1) {
                    board[0][1] = "X";
                } else {
                    board[0][1] = "O";
                }
            }
            if (input == 3) { //a3
                if (turn % 2 == 1) {
                    board[0][2] = "X";
                } else {
                    board[0][2] = "O";
                }
            }
            if (input == 4) { //a4
                if (turn % 2 == 1) {
                    board[1][0]= "X";
                } else {
                    board[1][0]= "O";
                }
            }
            if (input == 5) { //a5
                if (turn % 2 == 1) {
                    board[1][1] = "X";
                } else {
                    board[1][1] = "O";
                }
            }
            if (input == 6) { //a6
                if (turn % 2 == 1) {
                    board[1][2] = "X";
                } else {
                    board[1][2] = "O";
                }
            }
            if (input == 7) { //a7
                if (turn % 2 == 1) {
                    board[2][0] = "X";
                } else {
                    board[2][0] = "O";
                }
            }
            if (input == 8) { //a8
                if (turn % 2 == 1) {
                    board[2][1] = "X";
                } else {
                    board[2][1] = "O";
                }
            }
            if (input == 9) { //a9
                if (turn % 2 == 1) {
                    board[2][2] = "X";
                } else {
                    board[2][2] = "O";
                }
            }
            //displaying board
           display(board);


            //Win conditions
            if ((board[0][1] == board[1][1] && board[1][1] == board[2][1]) || (board[0][0] == board[1][1] && board[0][0] ==  board[2][2])
                    || (board[0][2] == board[1][1] && board[1][1] == board[2][0]) || (board[1][0] == board[1][1] && board[1][1] == board[1][2])
                    || (board[0][0] == board[0][1] && board[0][1] == board[0][2]) || (board[0][0] == board[1][0] && board[1][0] == board[2][0])
                    || (board[0][2] == board[1][2] && board[1][2] ==  board[2][2]) || (board[2][0] == board[2][1] && board[2][1] ==  board[2][2])) {
                if (turn % 2 == 1) {
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
                game = 1;
            }
            turn++;
            if (turn == 10) {
                System.out.println("Draw");
                game = 1; //is game over
            }
        }
    }

    public static void display(String[][] a) { //method to display board
        int rows = 3;
        int col = 3;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < col; j++)
            {
                System.out.print(a[i][j] + " " );
            }
            System.out.println();
        }
    }
}
