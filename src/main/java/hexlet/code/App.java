package hexlet.code;

import hexlet.code.constants.GameNumber;

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

        Engine engine = new Engine();
        switch (gameNumber) {
            case    GameNumber.GREETING, GameNumber.PARITY_CHECK, GameNumber.CALCULATOR,
                    GameNumber.GCD, GameNumber.PROGRESSION, GameNumber.PRIME
                    -> engine.setGameNumber(gameNumber);
            default -> System.exit(0);
        }

        System.out.println("Welcome to the Brain Games!");
        Cli cli = new Cli();
        String playerName = cli.enterName();

        if (!gameNumber.equals(GameNumber.GREETING)) {
            engine.setPlayerName(playerName);
            engine.playGame();
        }
    }
}
