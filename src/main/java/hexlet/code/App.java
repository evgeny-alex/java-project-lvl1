package hexlet.code;

import hexlet.code.constants.GameNumber;
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
            case GameNumber.GREETING -> Engine.greeting();
            case GameNumber.PARITY_CHECK -> Engine.playGame(ParityCheck.getGameQuestion(), ParityCheck.getGameInfo());
            case GameNumber.CALCULATOR -> Engine.playGame(Calculator.getGameQuestion(), Calculator.getGameInfo());
            case GameNumber.GCD -> Engine.playGame(CommonDivisor.getGameQuestion(), CommonDivisor.getGameInfo());
            case GameNumber.PROGRESSION -> Engine.playGame(Progression.getGameQuestion(), Progression.getGameInfo());
            case GameNumber.PRIME -> Engine.playGame(Prime.getGameQuestion(), Prime.getGameInfo());
            default -> System.exit(0);
        }
    }
}
