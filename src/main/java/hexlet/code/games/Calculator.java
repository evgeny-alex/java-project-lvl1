package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.dto.QuestionInfo;

public final class Calculator {

    private static final int MAX_NUMBER = 20;

    private static final int SUM_CODE_OPERATION = 0;

    private static final int MINUS_CODE_OPERATION = 1;

    private static final int COUNT_OPERATION = 3;

    public static void fillGameQuestion(String question) {
        question = "What is the result of the expression?";
    }

    public static void fillQuestionInfo(QuestionInfo questionInfo) {
        int firstNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
        int secondNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
        int codeOperation = Engine.RANDOM.nextInt(COUNT_OPERATION);

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
