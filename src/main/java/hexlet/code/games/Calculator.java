package hexlet.code.games;

import hexlet.code.dto.QuestionInfo;

public final class Calculator extends Engine {

    private static final int MAX_NUMBER = 20;

    private static final int SUM_CODE_OPERATION = 0;

    private static final int MINUS_CODE_OPERATION = 1;

    private static final int COUNT_OPERATION = 3;

    @Override
    protected String getGameQuestion() {
        return "What is the result of the expression?";
    }

    @Override
    protected void fillQuestionInfo(QuestionInfo questionInfo) {
        int firstNumber = RANDOM.nextInt(MAX_NUMBER);
        int secondNumber = RANDOM.nextInt(MAX_NUMBER);
        int codeOperation = RANDOM.nextInt(COUNT_OPERATION);

        char symbolOperation;
        int answer;
        switch (codeOperation) {
            case SUM_CODE_OPERATION -> {
                symbolOperation = '+';
                answer = firstNumber + secondNumber;
            }
            case MINUS_CODE_OPERATION -> {
                symbolOperation = '-';
                answer = firstNumber - secondNumber;
            }
            default -> {
                symbolOperation = '*';
                answer = firstNumber * secondNumber;
            }
        }

        questionInfo.setQuestion(firstNumber + " " + symbolOperation + " " + secondNumber);
        questionInfo.setCorrectAnswer(String.valueOf(answer));
    }
}
