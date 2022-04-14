package hexlet.code.games;

import hexlet.code.Engine;

public final class Prime {

    private static final int MAX_NUMBER = 100;

    private static final int MIN_NUMBER = 2;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    public static String getGameQuestion() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_QUESTIONS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_QUESTIONS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int number = Engine.RANDOM.nextInt(MIN_NUMBER, MAX_NUMBER);
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
        for (int i = 2; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
