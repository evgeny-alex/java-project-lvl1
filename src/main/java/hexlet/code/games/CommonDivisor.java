package hexlet.code.games;

import hexlet.code.Engine;

public final class CommonDivisor {

    private static final int MAX_NUMBER = 100;

    public static String getGameQuestion() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_QUESTIONS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_QUESTIONS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int firstNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
            int secondNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
            int answer = greatestCommonDivisor(firstNumber, secondNumber);

            questionInfo[0] = firstNumber + " " + secondNumber;
            questionInfo[Engine.COUNT_INFO - 1] = String.valueOf(answer);

            gameInfo[i] = questionInfo;
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
