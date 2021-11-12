import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class MineSweeperTerminal {

    public static void main(String[] args) {

        //declaring all variables
        String inOne, inTwo;
        int a, b, ne, n, nw, e, w, se, s, sw, count;
        int mineCount = 0;
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean mine = false;
        boolean gameover = false;
        Random rand = new Random();

        //lets player decide size of board
        System.out.println("What size board would you like? This number will automatically be put in a (size) x (size) square");
        int size = scanner.nextInt();
        while (size <= 0) {
            System.out.println("INVALID INPUT PLEASE TRY AGAIN");
            size = scanner.nextInt();
        }

        //actual board
        String[][] board = new String[size][size];

        //display board
        String[][] display = new String[size][size];

        //puts blank values in the display board
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display.length; j++) {
                display[i][j] = "  ";
            }
        }

        //randomizes board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.toString(rand.nextInt(100) + 1);
            }
        }

        //mine generator
        for (int k = 0; k < board.length; k++) {
            for (int h = 0; h < board.length; h++) {
                if (board[k][h].equals("20") || board[k][h].equals("19") || board[k][h].equals("18") || board[k][h].equals("17") || board[k][h].equals("16") || board[k][h].equals("15") || board[k][h].equals("14") || board[k][h].equals("13") || board[k][h].equals("12") || board[k][h].equals("11") || board[k][h].equals("10") || board[k][h].equals("9") || board[k][h].equals("8") || board[k][h].equals("7") || board[k][h].equals("6") || board[k][h].equals("5") || board[k][h].equals("4") || board[k][h].equals("3") || board[k][h].equals("2") || board[k][h].equals("1")) {
                    board[k][h] = "X";
                }
            }
        }
        for (int l = 0; l < board.length; l++) {
            for (int m = 0; m < board.length; m++) {
                if (!board[l][m].equals("X") && !board[l][m].equals("20") && !board[l][m].equals("19") && !board[l][m].equals("18") && !board[l][m].equals("17") && !board[l][m].equals("16") && !board[l][m].equals("15") && !board[l][m].equals("14") && !board[l][m].equals("13") && !board[l][m].equals("12") && !board[l][m].equals("11") && !board[l][m].equals("10") && !board[l][m].equals("9") && !board[l][m].equals("8") && !board[l][m].equals("7") && !board[l][m].equals("6") && !board[l][m].equals("5") && !board[l][m].equals("4") && !board[l][m].equals("3") && !board[l][m].equals("2") && !board[l][m].equals("1")) {
                    board[l][m] = " ";
                }
            }
        }

        //counts amount of mines around a space
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].equals("X")) {
                    try {
                        if (board[i - 1][j - 1].equals("X")) {
                            ne = 1;
                        } else {
                            ne = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        ne = 0;
                    }
                    try {
                        if (board[i - 1][j].equals("X")) {
                            n = 1;
                        } else {
                            n = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        n = 0;
                    }
                    try {
                        if (board[i - 1][j + 1].equals("X")) {
                            nw = 1;
                        } else {
                            nw = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        nw = 0;
                    }
                    try {
                        if (board[i][j - 1].equals("X")) {
                            e = 1;
                        } else {
                            e = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        e = 0;
                    }
                    try {
                        if (board[i][j + 1].equals("X")) {
                            w = 1;
                        } else {
                            w = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        w = 0;
                    }
                    try {
                        if (board[i + 1][j - 1].equals("X")) {
                            se = 1;
                        } else {
                            se = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        se = 0;
                    }
                    try {
                        if (board[i + 1][j].equals("X")) {
                            s = 1;
                        } else {
                            s = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        s = 0;
                    }
                    try {
                        if (board[i + 1][j + 1].equals("X")) {
                            sw = 1;
                        } else {
                            sw = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        sw = 0;
                    }
                    count = ne + n + nw + e + w + se + s + sw;
                    board[i][j] = String.valueOf(count);
                }

            }
        }

        //counts total amount of mines
        for (String[] strings : board) {
            for (int j = 0; j < board.length; j++) {
                if (strings[j].equals("X"))
                    mineCount++;
            }
        }

        //sets mineDisplay to mineCount so mineDisplay can be changed in game
        int mineDisplay = mineCount;

        //start of game
        System.out.println("Welcome to MINESWEEPER!!!. Find all the mines to WIN.");

        //the game itself
        while (!mine && !gameover) {
            int correct = 0;
            System.out.println("Mine Count: " + mineDisplay);
            System.out.println("Type the desire row and column like this (row column). Type F to switch to flag mode.");

            for (int iii = 0; iii < display.length; iii++) {
                if (iii < 10) {
                    System.out.println(iii + " " + Arrays.deepToString(display[iii]));
                }
                else {
                    System.out.println(iii + Arrays.deepToString(display[iii]));
                }
            }

            System.out.print("   ");
            if (size < 13) {
                for (int i = 0; i < display.length; i++) {
                    System.out.print(i + "   ");
                }
            }
            else{
                for (int i = 0; i < display.length; i++) {
                    if (i > 9) {
                        System.out.print(i + "  ");
                    }
                    else{
                        System.out.print(i + "   ");
                    }
                }
            }

            System.out.println();

            String input = scan.nextLine();

            try {
                if (input.equals("F") || input.equals("f")) {
                    System.out.println("Type desired row and column for flag.");
                    String flag = scan.nextLine();
                    String[] mineFlag = flag.split(" ");
                    inOne = mineFlag[0];
                    inTwo = mineFlag[1];
                    a = Integer.parseInt(inOne);
                    b = Integer.parseInt(inTwo);
                    display[a][b] = "|>";
                    if (display[a][b].equals("|>")) {
                        mineDisplay--;
                    }

                } else {
                    String[] array = input.split(" ");
                    inOne = array[0];
                    inTwo = array[1];
                    a = Integer.parseInt(inOne);
                    b = Integer.parseInt(inTwo);
                    if (display[a][b].equals("|>")) {
                        mineDisplay++;
                    }
                    display[a][b] = board[a][b] + " ";
                    if (display[a][b].equals("X ")) {
                        mine = true;
                    }

                    if (display[a][b].equals("0 ")) {
                        try {
                            display[a - 1][b - 1] = board[a - 1][b - 1]  + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a - 1][b] = board[a - 1][b] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a - 1][b + 1] = board[a - 1][b + 1] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a][b - 1] = board[a][b - 1] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a][b + 1] = board[a][b + 1] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a + 1][b - 1] = board[a + 1][b - 1] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a + 1][b] = board[a + 1][b] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            display[a + 1][b + 1] = board[a + 1][b + 1] + " ";
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }


                    }


                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN");
            }

            for (int i = 0; i < display.length; i++) {
                for (int j = 0; j < display.length; j++) {
                    if (display[i][j].equals("|>") && board[i][j].equals("X")) {
                        correct++;
                    }
                }
            }
            if ((correct == mineCount) && mineDisplay == 0) gameover = true;
        }

        //winning result
        if (gameover) {
            System.out.println();
            System.out.println("YOU WIN :)");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j].equals("X")) {
                        board[i][j] = "|>";
                    }
                }
            }
            for (int i = 0; i < display.length; i++) {
                System.out.println(i + " " + Arrays.deepToString(board[i]));
            }
            System.out.print("   ");
            for (int i = 0; i < display.length; i++) {
                System.out.print(i + "  ");
            }
        }

        //losing result
        if (mine) {
            System.out.println();
            System.out.println("YOU LOSE :(");
            for (int i = 0; i < board.length; i++) {
                System.out.println(i + " " + Arrays.deepToString(board[i]));
            }
            System.out.print("   ");
            for (int i = 0; i < board.length; i++) {
                System.out.print(i + "  ");
            }
        }
    }
}