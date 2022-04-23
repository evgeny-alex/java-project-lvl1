package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class CommonDivisor {

    public static final Random RANDOM = new Random();

    private static final int MAX_NUMBER = 100;

    private static final String GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        Engine.playGame(GAME_QUESTION, getGameInfo());
    }

    private static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_ROUNDS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            String[] roundInfo = new String[Engine.COUNT_INFO];

            int firstNumber = RANDOM.nextInt(MAX_NUMBER);
            int secondNumber = RANDOM.nextInt(MAX_NUMBER);
            int answer = greatestCommonDivisor(firstNumber, secondNumber);

            roundInfo[0] = firstNumber + " " + secondNumber;
            roundInfo[Engine.COUNT_INFO - 1] = String.valueOf(answer);

            gameInfo[i] = roundInfo;
        }
        return gameInfo;
    }

    /**
     * Метод находит НОД чисел.
     *
     * @param firstNumber - первое число
     * @param secondNumber - второе число
     * @return - НОД входных чисел
     */
    private static int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }
        while (secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }
        }
        return firstNumber;
    }
}
