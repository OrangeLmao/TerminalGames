import java.util.*;

//Pranav Saran
//Period 4
public class main {
    public static void initializeBoard(String[][] gameBoard, pieces[] red, pieces[] black, int a) {
        for (int i = 0; i < 64; i++) { //setting board to blanks
            gameBoard[i / 8][i % 8] = ".";
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) { // initializes positions of checker pieces
                red[a] = new pieces(j * 2 + (i % 2), i + 5, false);
                i++;
                black[a] = new pieces(j * 2 + (i % 2), i - 1, false);
                i--;
                a++;
            }
        }
    }

    public static void displayBoard(String[][] gameBoard) {
        System.out.print(" ");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + i); //print top row and align
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(i); //print leftmost column and align
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + gameBoard[i][j]); //print out the rest of the board
            }
            System.out.println();
        }
    }

    public static void updateBoard(String[][] gameBoard, pieces[] red, pieces[] black) {
        for (int i = 0; i < 12; i++) {
            if (red[i].getY() < 8 && red[i].getX() < 8) {  // put red pieces on the board
                gameBoard[red[i].getY()][red[i].getX()] = "R";
            }
            if (black[i].getY() < 8 && black[i].getX() < 8) { //put black pieces on the board
                gameBoard[black[i].getY()][black[i].getX()] = "B";
            }

        }
    }

    public static void checkWinnner(boolean win, pieces[]black, boolean redWin){
        if (win) {
            for (int i = 0; i < 12; i++) { //check if red or black wins (redwin was declared as true)
                if (black[i].getY() != 20) redWin = false;
            }
            if (redWin) {
                System.out.println("Red Wins! Congratulations!");
            } else {
                System.out.println("Black Wins! Congratulations!");
            }
        }
    }

    public static void main(String[] args) {

        //Initialize variables + setup
        pieces pieces = new pieces();
        Scanner sc = new Scanner(System.in);

        int a = 0, x1 = 0, y1 = 0, turn = 0;


        boolean redwin = true;
        int pos = 0;
        boolean win = false;

        pieces[] black = new pieces[12];
        pieces[] red = new pieces[12];
        String[][] gameBoard = new String[8][8];

        initializeBoard(gameBoard, red, black, a);

        //Check win con every while loop iteration
        while (!win) {

            updateBoard(gameBoard, red, black);

            displayBoard(gameBoard);
            //movement for red
            if (turn % 2 == 0) {
                System.out.println("Red's movement turn, enter coordinates (y,x) ");
                x1 = sc.nextInt(); //take in inputs
                y1 = sc.nextInt();
                if (x1 < 8 && x1 >= 0 && y1 < 8 && y1 >= 0 && gameBoard[x1][y1].equals("R")) {
                    for (int i = 0; i < 12; i++) {
                        if (x1 == red[i].getY() && y1 == red[i].getX()) {
                            pieces = new pieces(x1, y1, red[i].kingStatus());
                            pos = i;
                        }
                        //check if valid move by using a "ghost checker" and recording his position
                    }
                    System.out.println("enter desired movement coords (y,x)");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    if (x1 < 8 && x1 >= 0 && y1 < 8 && y1 >= 0 && gameBoard[x1][y1].equals(".")) {
                        if (Math.abs(y1 - pieces.getY()) == 1 && (x1 - pieces.getX() == -1 ||
                                (Math.abs(x1 - pieces.getX()) == 1 && pieces.kingStatus()))) {
                            gameBoard[pieces.getX()][pieces.getY()] = ".";
                            red[pos].setY(x1);
                            red[pos].setX(y1);
                            if (x1 == 0) red[pos].makeKing(true);

                        } else if (Math.abs(y1 - pieces.getY()) == 2 && (x1 - pieces.getX() == -2 || (Math.abs(x1 - pieces.getX()) == 2
                                && pieces.kingStatus())) && gameBoard[(x1 + pieces.getX()) / 2][(y1 + pieces.getY()) / 2].equals("B")) {
                            gameBoard[pieces.getX()][pieces.getY()] = ".";
                            gameBoard[(x1 + pieces.getX()) / 2][(y1 + pieces.getY()) / 2] = "."; //remove taken piece
                            red[pos].setY(x1);
                            red[pos].setX(y1);
                            for (int i = 0; i < 12; i++) {
                                if (((x1 + pieces.getX()) / 2 == black[i].getY())
                                        && (((y1 + pieces.getY()) / 2) == black[i].getX())) {
                                    //deathnote old piece out of existence
                                    black[i].setY(20);
                                    black[i].setX(20);
                                }
                            }
                            turn--;
                            //allow extra turn to impliment additional turn if capture
                            if (x1 == 0) red[pos].makeKing(true);
                            //the following serves as output to reset red's turn
                        } else {
                            System.out.println("Invalid. Try Again!");
                            turn--;
                        }
                    } else {
                        System.out.println("Invalid. Try Again!");
                        turn--;
                    }

                } else {
                    System.out.println("Invalid. Try Again!");
                    turn--; //redo red's turn if there is no red piece at original position
                }
                turn++;
                //movement for black
            } else if (turn % 2 == 1) {
                System.out.println("Black's movement turn, enter coordinates (y,x) ");
                x1 = sc.nextInt(); //take in inputs
                y1 = sc.nextInt();
                if (x1 < 8 && x1 >= 0 && y1 < 8 && y1 >= 0 && gameBoard[x1][y1].equals("R")) {
                    for (int i = 0; i < 12; i++) {
                        if (x1 == black[i].getY() && y1 == black[i].getX()) {
                            pieces = new pieces(x1, y1, black[i].kingStatus());
                            pos = i;
                        }//check if valid move by using a "ghost checker" and recording his position
                    }
                    System.out.println("enter desired movement coords (y,x)");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    if (x1 < 8 && x1 >= 0 && y1 < 8 && y1 >= 0 && gameBoard[x1][y1].equals(".")) {
                        if (Math.abs(y1 - pieces.getY()) == 1 && (x1 - pieces.getX() == -1 ||
                                (Math.abs(x1 - pieces.getX()) == 1 && pieces.kingStatus()))) {
                            gameBoard[pieces.getX()][pieces.getY()] = ".";
                            black[pos].setY(x1);
                            black[pos].setX(y1);
                            if (x1 == 0) black[pos].makeKing(true);

                        } else if (Math.abs(y1 - pieces.getY()) == 2 && (x1 - pieces.getX() == -2 || (Math.abs(x1 - pieces.getX()) == 2
                                && pieces.kingStatus())) && gameBoard[(x1 + pieces.getX()) / 2][(y1 + pieces.getY()) / 2].equals("B")) {
                            gameBoard[pieces.getX()][pieces.getY()] = ".";
                            gameBoard[(x1 + pieces.getX()) / 2][(y1 + pieces.getY()) / 2] = "."; //remove taken piece
                            black[pos].setY(x1);
                            black[pos].setX(y1);
                            for (int i = 0; i < 12; i++) {
                                if (((x1 + pieces.getX()) / 2 == red[i].getY())
                                        && (((y1 + pieces.getY()) / 2) == red[i].getX())) {
                                    //deathnote old piece out of existence
                                    red[i].setY(20);
                                    red[i].setX(20);
                                }
                            }
                            turn--;
                            //allow extra turn to impliment additional turn if capture
                             if (x1 == 0) black[pos].makeKing(true);
                            //the following serves as output to reset black's turn
                        } else {
                            System.out.println("Invalid. Try Again!");
                            turn--;
                        }
                    } else {
                        System.out.println("Invalid. Try Again!");
                        turn--;
                    }

                } else {
                    System.out.println("Invalid. Try Again!");
                    turn--; //redo black's turn if there is no red piece at original position
                }
                turn++;
            }
            win = true;
            for (int i = 0; i < 12; i++) {
                if (red[i].getY() != 20 || black[i].getY() != 20) {
                    win = false;
                }//if win then break lop
            }

        }

        checkWinnner(win,black, redwin);

    }

}