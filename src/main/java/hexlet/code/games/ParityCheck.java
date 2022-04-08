package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.dto.QuestionInfo;

public final class ParityCheck {

    private static final int MAX_NUMBER = 20;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    public static String getGameQuestion() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static void fillQuestionInfo(QuestionInfo questionInfo) {
        int number = Engine.RANDOM.nextInt(MAX_NUMBER);
        String correctAnswer = (number % 2 == 0) ? YES_ANSWER : NO_ANSWER;

        questionInfo.setQuestion(String.valueOf(number));
        questionInfo.setCorrectAnswer(correctAnswer);
    }
}
