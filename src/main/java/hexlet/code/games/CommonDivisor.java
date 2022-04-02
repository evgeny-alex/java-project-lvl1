package hexlet.code.games;

import hexlet.code.dto.QuestionInfo;

public final class CommonDivisor extends Engine {

    private static final int MAX_NUMBER = 100;

    @Override
    protected String getGameQuestion() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected void fillQuestionInfo(QuestionInfo questionInfo) {
        int firstNumber = RANDOM.nextInt(MAX_NUMBER);
        int secondNumber = RANDOM.nextInt(MAX_NUMBER);
        int answer = greatestCommonDivisor(firstNumber, secondNumber);

        questionInfo.setQuestion(firstNumber + " " + secondNumber);
        questionInfo.setCorrectAnswer(String.valueOf(answer));
    }

    /**
     * Метод находит НОД чисел
     *
     * @param firstNumber - первое число
     * @param secondNumber - второе число
     * @return - НОД входных чисел
     */
    private int greatestCommonDivisor(int firstNumber, int secondNumber) {
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
