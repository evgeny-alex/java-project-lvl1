package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static String playerName = "";

    private static final int COUNT_ROUNDS = 3;

    public static final Random RANDOM = new Random();

    private static final Scanner SCANNER = new Scanner(System.in);

    public static final int COUNT_QUESTIONS = 3;

    public static final int COUNT_INFO = 2;

    /**
     * Метод запускает игру.
     *
     * @author Evgeny Aleksandrov
     * @param gameQuestion - условие игры
     * @param gameInfo - вопросы игры
     * @version 1.0
     */
    public static void playGame(String gameQuestion, String[][] gameInfo) {
        greeting();
        System.out.println(gameQuestion);
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            playRound(gameInfo[i]);
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    /**
     * Приветствие с игроком и сохранение имени.
     */
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = Cli.enterAndGetName();
        System.out.println("Hello, " + playerName + "!");
    }

    private static void playRound(String[] questionInfo) {
        System.out.println("Question: " + questionInfo[0]);
        System.out.print("Your answer: ");
        String answer = SCANNER.next();
        String correctAnswer = questionInfo[COUNT_INFO - 1];

        if (correctAnswer.equals(answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n"
                    + "Let's try again, " + playerName + "!");
            System.exit(0);
        }
    }
}
