package hexlet.code;

import hexlet.code.constants.GameNumber;
import hexlet.code.games.*;

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

        Engine engineGame = null;
        switch (gameNumber) {
            case GameNumber.GREETING -> {
            }
            case GameNumber.PARITY_CHECK -> engineGame = new ParityCheck();
            case GameNumber.CALCULATOR ->   engineGame = new Calculator();
            case GameNumber.GCD ->          engineGame = new CommonDivisor();
            case GameNumber.PROGRESSION ->  engineGame = new Progression();
            case GameNumber.PRIME ->        engineGame = new Prime();
            default -> System.exit(0);
        }

        System.out.println("Welcome to the Brain Games!");
        Cli cli = new Cli();
        String playerName = cli.enterName();

        if (engineGame != null) {
            engineGame.setPlayerName(playerName);
            engineGame.playGame();
        }
    }
}
