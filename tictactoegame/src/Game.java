
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        String[][] gameField = {{" ", " ", "1", "2", "3"}, {" ", " ", "-", "-", "-"}, {"A", "|", " ", " ", " "}, {"B", "|", " ", " ", " "}, {"C", "|", " ", " ", " "}};
        String[] playerNames = new String[2];

        printRulesAndGetPlayersNames(playerNames);
        Player player1 = new Player(playerNames[0], "X");
        Player player2 = new Player(playerNames[1], "O");
        printGameField(gameField);
        while (true) {

            System.out.println(playerNames[0]+" (X)");
            player1.playerMove(gameField);
            printGameField(gameField);
            if (player1.checkIfWin(gameField).equals("win")) {
                System.out.println(playerNames[0] + " wins!Congratulations!!!");
                break;
            } else if (player1.checkIfWin(gameField).equals("draw")) {
                System.out.println("Draw.Nobody wins.");
                break;
            }

            System.out.println(playerNames[1]+" (O)");
            player2.playerMove(gameField);
            printGameField(gameField);
            player2.checkIfWin(gameField);
            if (player2.checkIfWin(gameField).equals("win")) {
                System.out.println(playerNames[1] + " wins!!!Congratulations!!!");
                break;
            } else if (player2.checkIfWin(gameField).equals("draw")) {
                System.out.println("Draw. Nobody wins.");
                break;
            }

        }

    }


    /**
     * method for printing rules and getting names from players.
     *
     * @param names
     */
    private static void printRulesAndGetPlayersNames(String[] names) {
        Scanner input = new Scanner(System.in);
        //printing rules for players
        System.out.println("First Player is 'X'" + "\n" + "Second Player is 'O'" + "\n"
                + "To put your symbol enter line (a,b,c)  and column (1,2,3), for example:a1" + "\n"
                + "The winner is the person who first put his characters vertically, horizontally or diagonally");


        // getting names from players
        System.out.println("Enter Player 1 name:");
        String player1Name = input.next();
        System.out.println("Enter Player 2 name:");
        String player2Name = input.next();
        System.out.println("Hello" + " " + player1Name + " " + "i" + " " + player2Name + "! Let's start!");
        names[0] = player1Name;
        names[1] = player2Name;
    }

    /**
     * method for printing gameField Array.
     *
     * @param arr
     */
    private static void printGameField(String[][] arr) {
        for (String[] strings : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(strings[j]);
            }

            System.out.println();

        }


    }



}
