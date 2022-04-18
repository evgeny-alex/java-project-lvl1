package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int COUNT_ROUNDS = 3;

    private static final Scanner SCANNER = new Scanner(System.in);

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
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = SCANNER.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameQuestion);

        for (int i = 0; i < COUNT_ROUNDS; i++) {
            System.out.println("Question: " + gameInfo[i][0]);
            System.out.print("Your answer: ");
            String answer = SCANNER.next();
            String correctAnswer = gameInfo[i][COUNT_INFO - 1];

            if (correctAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n"
                        + "Let's try again, " + playerName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
