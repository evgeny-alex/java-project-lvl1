package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.CommonDivisor;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\040""");

        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();

        switch (gameNumber) {
            case "1" -> Cli.greet();
            case "2" -> ParityCheck.startGame();
            case "3" -> Calculator.startGame();
            case "4" -> CommonDivisor.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            default -> System.exit(0);
        }
    }
}
