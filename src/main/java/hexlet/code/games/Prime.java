package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.dto.QuestionInfo;

public final class Prime {

    private static final int MAX_NUMBER = 100;

    private static final int MIN_NUMBER = 2;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    public static void fillGameQuestion(String question) {
        question = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static void fillQuestionInfo(QuestionInfo questionInfo) {
        int number = Engine.RANDOM.nextInt(MIN_NUMBER, MAX_NUMBER);
        boolean isPrime = isPrimeNumber(number);

        questionInfo.setQuestion(String.valueOf(number));
        questionInfo.setCorrectAnswer(isPrime ? YES_ANSWER : NO_ANSWER);
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
