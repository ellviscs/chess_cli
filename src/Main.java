import java.util.Scanner;

class Main {

    static void main() {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        board.getNewBoard();

        while (true) {
            boolean isValid = false;
            while (!isValid) {
                board.getBoard(true);
                System.out.println("White To Play");
                System.out.println("Please enter a valid move: ");
                String input = sc.next();
                String[] arrayOfInput = input.split("");
                int[] inputNumber = notationToInteger(arrayOfInput);
                isValid = board.getMove(inputNumber[0], inputNumber[1], inputNumber[2], inputNumber[3]);
            }
            isValid = false;
            while (!isValid) {
                board.getBoard(false);
                System.out.println("Black To Play");
                System.out.println("Please enter a valid move: ");
                String input = sc.next();
                String[] arrayOfInput = input.split("");
                int[] inputNumber = notationToInteger(arrayOfInput);
                isValid = board.getMove(inputNumber[0], inputNumber[1], inputNumber[2], inputNumber[3]);
            }
        }
    }

    public static int[] notationToInteger(String[] input) {
        int[] inputNumber = new int[4];

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                inputNumber[i] = input[i].charAt(0) - 'a' + 1;
            } else {
                inputNumber[i] = Integer.parseInt(input[i]);
            }
        }
        return inputNumber;
    }
}