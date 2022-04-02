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

    private int greatestCommonDivisor(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
