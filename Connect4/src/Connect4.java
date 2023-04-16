//Pranav Saran
//Period 4

import java.util.*;

public class Connect4 {
    public static void main(String[] args) {

        boolean game = true; //for repeating while loop
        int turn = 1; //turn counter
        int input; //initializing variable for later
        //making the orignial board
        String[][] board =
                {{"-", "-", "-", "-", "-", "-", "-"},
                        {"-", "-", "-", "-", "-", "-", "-"},
                        {"-", "-", "-", "-", "-", "-", "-"},
                        {"-", "-", "-", "-", "-", "-", "-"},
                        {"-", "-", "-", "-", "-", "-", "-"},
                        {"-", "-", "-", "-", "-", "-", "-"}}; //creating initial board

        Scanner sc = new Scanner(System.in); //scanner
        display(board); //displays board originally
        while (game) {
            //turn %2 is turn selector
            if (turn % 2 == 1) {
                System.out.println("Player 1's turn (X)");
                System.out.println("Please select the column in which you would like to place your piece.");
            } else {
                System.out.println("Player 2's turn (O)");
                System.out.println("Please select the column in which you would like to place your piece.");
            }
            int response = sc.nextInt();
            sc.nextLine();
            //declaring input as the array col selector (1 less than board col)
            input = response - 1;

            drop(board, input, turn); // movement

            //Win Conditions:

            game = vertical(board, game);

            game = horizontal(board, game);

            game = checkup(board, game);

            game = checkdown(board, game);

            //draw condition
            if (turn >= 42) {
                System.out.println("DRAW");
                System.out.println("....how did you draw in connect 4....");
            }

            turn++; //after every turn increases by 1
            display(board); //displays board after winning or after the turn is over
        }
    }

    public static boolean vertical(String[][] board, boolean game) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals("X") && board[j + 1][i].equals("X") && board[j + 2][i].equals("X") && board[j + 3][i].equals("X")) {
                    System.out.println("Player 1 wins");
                    game = false;
                } else if (board[j][i].equals("0") && board[j + 1][i].equals("0") && board[j + 2][i].equals("0") && board[j + 3][i].equals("0")) {
                    System.out.println("Player 2 wins ");
                    game = false;
                }
            }
        }
        return game;
    }

    public static boolean horizontal(String[][] board, boolean game) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X") && board[i][j + 1].equals("X") && board[i][j + 2].equals("X") && board[i][j + 3].equals("X")) {
                    System.out.println("Player 1 wins");
                    game = false;
                } else if (board[i][j].equals("0") && board[i][j + 1].equals("0") && board[i][j + 2].equals("0") && board[i][j + 3].equals("0")) {
                    System.out.println("Player 2 wins ");
                    game = false;
                }
            }
        }
        return game;
    }

    public static boolean checkup(String[][] board, boolean game) {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X") && board[i - 1][j + 1].equals("X") && board[i - 2][j + 2].equals("X") && board[i - 3][j + 3].equals("X")) {
                    System.out.println("Player 1 wins");
                    game = false;
                } else if (board[i][j].equals("0") && board[i - 1][j + 1].equals("0") && board[i - 2][j + 2].equals("0") && board[i - 3][j + 3].equals("0")) {
                    System.out.println("Player 2 wins ");
                    game = false;
                }
            }
        }
        return game;
    }

    public static boolean checkdown(String[][] board, boolean game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                if (board[i][j].equals("X") && board[i + 1][j + 1].equals("X") && board[i + 2][j + 2].equals("X") && board[i + 3][j + 3].equals("X")) {
                    System.out.println("Player 1 wins");
                    game = false;
                } else if (board[i][j].equals("0") && board[i + 1][j + 1].equals("0") && board[i + 2][j + 2].equals("0") && board[i + 3][j + 3].equals("0")) {
                    System.out.println("Player 2 wins ");
                    game = false;
                }
            }
        }
        return game;
    }

    public static void display(String[][] a) { //method to display board
        System.out.println("1 " + "2 " + "3 " + "4 " + "5 " + "6 " + "7 "); //hard code column selector
        int rows = 6;
        int col = 7;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] drop(String[][] board, int input, int turn) {
        if (turn % 2 == 1) { //shmoovement
            if (board[5][input].equals("-")) {
                board[5][input] = "X";
            } else {
                if (board[4][input].equals("-")) {
                    board[4][input] = "X";
                } else {
                    if (board[3][input].equals("-")) {
                        board[3][input] = "X";
                    } else {
                        if (board[2][input].equals("-")) {
                            board[2][input] = "X";
                        } else {
                            if (board[1][input].equals("-")) {
                                board[1][input] = "X";
                            } else {
                                if (board[0][input].equals("-")) {
                                    board[0][input] = "X";
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (board[5][input].equals("-")) {
                board[5][input] = "0";
            } else {
                if (board[4][input].equals("-")) {
                    board[4][input] = "0";
                } else {
                    if (board[3][input].equals("-")) {
                        board[3][input] = "0";
                    } else {
                        if (board[2][input].equals("-")) {
                            board[2][input] = "0";
                        } else {
                            if (board[1][input].equals("-")) {
                                board[1][input] = "0";
                            } else {
                                if (board[0][input].equals("-")) {
                                    board[0][input] = "0";
                                }
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

}
