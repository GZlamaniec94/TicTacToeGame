
import java.util.Scanner;

class Player {
    private String name;
    private String inputSign;

    Player(String name, String inputSign) {
        this.name = name;
        this.inputSign = inputSign;
    }

    public void playerMove(String[][] arr) {
        Scanner input = new Scanner(System.in);
        int line = 0;
        int column = 0;

        while (true) {
            String playerMove = input.next();
            if (playerMove.length() < 3) {
                if (playerMove.contains("a") || playerMove.contains("A")) {
                    line = 2;
                } else if (playerMove.contains("b") || playerMove.contains("B")) {
                    line = 3;
                } else if (playerMove.contains("c") || playerMove.contains("C")) {
                    line = 4;
                }

                if (playerMove.contains("1")) {
                    column = 2;
                } else if (playerMove.contains("2")) {
                    column = 3;
                } else if (playerMove.contains("3")) {
                    column = 4;
                }
                if (arr[line][column].equals(" ")) {
                    arr[line][column] = inputSign;
                    break;
                } else if (!arr[line][column].equals(" ")) {
                    System.out.println("Incorrect field.Please choose another:");

                }
            } else {
                System.out.println("Incorrect field.Please choose another:");
            }

        }
    }


    public String checkIfWin(String[][] arr) {

        String winOrDraw = "";
        int drawLevel=0;


        for (int i = 2; i < arr.length; i++) {
            /**
             * check who win  horizontally
             */
            if (arr[i][2].equals(inputSign) && arr[i][3].equals(inputSign) && arr[i][4].equals(inputSign)) {
                winOrDraw = "win";
            }
            /**
             * check if win vertically
             */
            else if (arr[2][i].equals(inputSign) && arr[3][i].equals(inputSign) && arr[4][i].equals(inputSign)) {
                winOrDraw = "win";
            }

            /**
             * check if win diagonally
             */
            else if (arr[2][4].equals(inputSign) && arr[3][3].equals(inputSign) && arr[4][2].equals(inputSign)) {
                winOrDraw = "win";
            }


        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (arr[i][j].equals("X")||arr[i][j].equals("O")){
                    drawLevel+=1;
                }

            }


        }
        if (drawLevel==9){
            winOrDraw="draw";
        }



        return winOrDraw;

    }

}
