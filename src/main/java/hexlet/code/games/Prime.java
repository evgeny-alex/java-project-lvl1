package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class Prime {

    public static final Random RANDOM = new Random();

    private static final int MAX_NUMBER = 100;

    private static final int MIN_NUMBER = 2;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    private static final String GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        Engine.playGame(GAME_QUESTION, getGameInfo());
    }

    private static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_ROUNDS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int number = RANDOM.nextInt(MIN_NUMBER, MAX_NUMBER);
            boolean isPrime = isPrimeNumber(number);

            questionInfo[0] = String.valueOf(number);
            questionInfo[Engine.COUNT_INFO - 1] = isPrime ? YES_ANSWER : NO_ANSWER;

            gameInfo[i] = questionInfo;
        }
        return gameInfo;
    }

    /**
     * Метод определяет является ли число простым.
     *
     * @param number - проверяемое число
     * @return - true, если да; false, если нет
     */
    private static boolean isPrimeNumber(int number) {
        if (number < 0 || number == 1 || number == 0) {
            return false;
        }
        for (int i = 2; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
